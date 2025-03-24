package beyondMedicine.com.backend.domains.user.util

object VersionVerifyUtil {
    @Suppress("ktlint:standard:property-naming")
    private val regex = """(\d+)\.(\d+)\.(\d+)(?:-(alpha|beta)\.(\d+))?""".toRegex()

    fun verifyVersion(
        reqVersion: String,
        standardVersion: String,
    ): Boolean {
        val reqVersionList = parseVersion(reqVersion)
        val standardVersionList = parseVersion(standardVersion)

        for (i in 1..reqVersionList.size) {
            if (standardVersionList[i] > reqVersionList[i]) {
                return true
            }
        }

        return false
    }

    private fun parseVersion(version: String): List<Int> {
        val (major, minor, patch, label, labelVersion) =
            regex.matchEntire(version)?.destructured
                ?: throw IllegalArgumentException("Invalid version format: $version")

        return listOf(
            major.toInt(),
            minor.toInt(),
            patch.toInt(),
            mapOf("alpha" to 1, "beta" to 2).getOrDefault(label, 3),
            labelVersion.toIntOrNull() ?: 99999,
        )
    }
}
