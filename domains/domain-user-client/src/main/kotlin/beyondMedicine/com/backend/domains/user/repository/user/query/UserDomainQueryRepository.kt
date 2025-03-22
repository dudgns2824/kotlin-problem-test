package beyondMedicine.com.backend.domains.user.repository.user.query

import beyondMedicine.com.backend.commons.core.exception.byndMdcnException
import beyondMedicine.com.backend.domains.user.entity.QUserEntity.userEntity
import beyondMedicine.com.backend.domains.user.exception.DomainUserErrCode
import beyondMedicine.com.backend.domains.user.repositorybus.user.query.IUserDomainQueryRepositoryBus
import beyondMedicine.com.backend.domains.user.util.BaseRepository
import beyondMedicine.com.backend.domains.user.util.repositoryUtil.user.UserRepoUtil
import org.springframework.stereotype.Repository

@Repository
class UserDomainQueryRepository :
    BaseRepository(),
    IUserDomainQueryRepositoryBus {
    override fun getUserDetail(id: String) =
        queryFactory
            .select(UserRepoUtil.ceUserDetail())
            .from(userEntity)
            .where(userEntity.userId.eq(id))
            .fetchOne()

    override fun isUserExist(userId: String) = queryFactory
        .select(userEntity.userId)
        .from(userEntity)
        .where(userEntity.userId.eq(userId))
        .fetchOne() != null

}
