package beyondMedicine.com.backend.domains.user.repository.user.command

import beyondMedicine.com.backend.domains.user.entity.QUserEntity.userEntity
import beyondMedicine.com.backend.domains.user.repositorybus.user.command.IUserDomainCommandRepositoryBus
import beyondMedicine.com.backend.domains.user.util.BaseRepository
import org.springframework.stereotype.Repository

@Repository
class UserDomainCommandRepository :
    BaseRepository(),
    IUserDomainCommandRepositoryBus {
    override fun updateUserPrescriptionCode(
        userId: String,
        prescriptionCode: String,
    ) = queryFactory
        .update(userEntity)
        .set(userEntity.prescriptionCode, prescriptionCode)
        .where(userEntity.userId.eq(userId))
        .execute() > 0
}
