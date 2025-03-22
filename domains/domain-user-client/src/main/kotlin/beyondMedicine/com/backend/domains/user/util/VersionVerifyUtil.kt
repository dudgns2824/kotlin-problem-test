package beyondMedicine.com.backend.domains.user.util

import beyondMedicine.com.backend.commons.core.exception.byndMdcnException
import beyondMedicine.com.backend.domains.user.enumeration.user.VerifyVersionType
import beyondMedicine.com.backend.domains.user.exception.DomainUserErrCode

object VersionVerifyUtil {
    @Suppress("ktlint:standard:property-naming")
    private val regex = """(\d+)\.(\d+)\.(\d+)(?:-(alpha|beta)\.(\d+))?""".toRegex()

    fun verifyVersion(
        reqVersion: String,
        standardVersion: String,
        verifyVersionType: VerifyVersionType
    ): Boolean {
        val reqVersionList = parseVersion(reqVersion)
        val standardVersionList = parseVersion(standardVersion)

        // 최근 버전 비교일경우
        if (verifyVersionType == VerifyVersionType.RECENT) {
            for (i in 0..4) {
                if (standardVersionList[i] > reqVersionList[i]) {
                    return false
                }
                if (reqVersionList[i] > standardVersionList[i]) {
                    throw byndMdcnException(DomainUserErrCode.VERSION_NOT_VALID)
                }
            }
        } else if (verifyVersionType == VerifyVersionType.MINIMUM) { //최소 버전 비교 일 경우
            var biggerThenComparison = false

            for (i in 0..4) {
                if (reqVersionList[i] > standardVersionList[i]) {
                    biggerThenComparison = true
                }
                if (!biggerThenComparison && standardVersionList[i] > reqVersionList[i]) {
                    return false
                }
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
