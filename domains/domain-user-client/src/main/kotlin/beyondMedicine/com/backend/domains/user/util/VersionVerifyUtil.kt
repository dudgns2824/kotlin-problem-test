package beyondMedicine.com.backend.domains.user.util

import beyondMedicine.com.backend.commons.core.exception.byndMdcnException
import beyondMedicine.com.backend.domains.user.exception.DomainUserErrCode

object VersionVerifyUtil {
    @Suppress("ktlint:standard:property-naming")
    private val regex = """(\d+)\.(\d+)\.(\d+)(?:-(alpha|beta)\.(\d+))?""".toRegex()

    fun verifyVersion(
        reqVersion: String,
        standardVersion: String,
    ): Boolean {
        val reqVersionList = parseVersion(reqVersion)
        val standardVersionList = parseVersion(standardVersion)

        for (i in 0..4) {
            if (standardVersionList[i] > reqVersionList[i]) {
                return false
            }
        }

        return true
    }

    private fun parseVersion(version: String): List<Int> {
        val (major, minor, patch, label, labelVersion) =
            regex.matchEntire(version)?.destructured
                ?: throw byndMdcnException(DomainUserErrCode.VERSION_NOT_VALID)

        return listOf(
            major.toInt(),
            minor.toInt(),
            patch.toInt(),
            mapOf("alpha" to 1, "beta" to 2).getOrDefault(label, 3),
            labelVersion.toIntOrNull() ?: 99999,
        )
    }
}
