package beyondMedicine.com.backend.domains.user.service.user.query

import beyondMedicine.com.backend.commons.core.exception.byndMdcnException
import beyondMedicine.com.backend.domains.prescription.servicebus.prescriptionCode.query.IPrescriptionCodeDomainQueryServiceBus
import beyondMedicine.com.backend.domains.user.dto.user.request.UserVerifyRequestDto
import beyondMedicine.com.backend.domains.user.enumeration.user.VerifyResponseType
import beyondMedicine.com.backend.domains.user.enumeration.user.VerifyVersionType
import beyondMedicine.com.backend.domains.user.exception.DomainUserErrCode
import beyondMedicine.com.backend.domains.user.repositorybus.user.query.IUserDomainQueryRepositoryBus
import beyondMedicine.com.backend.domains.user.repositorybus.version.query.IVersionDomainQueryRepositoryBus
import beyondMedicine.com.backend.domains.user.servicebus.user.query.IUserDomainQueryServiceBus
import beyondMedicine.com.backend.domains.user.util.VersionVerifyUtil
import org.springframework.stereotype.Service

@Service
class UserDomainQueryService(
    private val userDomainQueryRepositoryBus: IUserDomainQueryRepositoryBus,
    private val versionDomainQueryRepositoryBus: IVersionDomainQueryRepositoryBus,
    private val prescriptionCodeDomainQueryServiceBus: IPrescriptionCodeDomainQueryServiceBus,
) : IUserDomainQueryServiceBus {
    override fun getUserDetail(id: String) =
        userDomainQueryRepositoryBus.getUserDetail(id) ?: throw byndMdcnException(
            DomainUserErrCode.USER_NOT_EXIST,
        )

    override fun verifyUser(req: UserVerifyRequestDto): String {
        val versionDetail = versionDomainQueryRepositoryBus.getVersion(req.os, req.mode)

        var resStr = "정상"

        val recentVersionVerify =
            VersionVerifyUtil.verifyVersion(req.version, versionDetail.recentVersion, VerifyVersionType.RECENT)
        val minVersionVerify =
            VersionVerifyUtil.verifyVersion(req.version, versionDetail.minVersion, VerifyVersionType.MINIMUM)

        if (req.hash != versionDetail.hash) {
            throw byndMdcnException(DomainUserErrCode.HASH_NOT_VALID)
        }

        if (!recentVersionVerify) resStr = VerifyResponseType.UPDATE_RECOMMEND.description

        if (!minVersionVerify) resStr = VerifyResponseType.UPDATE_FORCE.description

        val userDetail = this.getUserDetail(req.userId)

        if (userDetail.prescriptionCode == null) {
            throw byndMdcnException(DomainUserErrCode.PRESCRIPTION_CODE_NOT_REGIST)
        }

        prescriptionCodeDomainQueryServiceBus.verifyUserPrescriptionCodeCheck(userDetail.prescriptionCode)

        return resStr

    }
}
