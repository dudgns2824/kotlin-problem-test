package beyondMedicine.com.backend.domains.user.service.user.command

import beyondMedicine.com.backend.domains.user.repositorybus.user.command.IUserDomainCommandRepositoryBus
import beyondMedicine.com.backend.domains.user.servicebus.user.command.IUserDomainCommandServiceBus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserDomainCommandService(
    private val userDomainCommandRepositoryBus: IUserDomainCommandRepositoryBus,
) : IUserDomainCommandServiceBus {
    override fun updateUserPrescriptionCode(
        userId: String,
        prescriptionCode: String,
    ) = userDomainCommandRepositoryBus.updateUserPrescriptionCode(userId, prescriptionCode)
}
