package beyondMedicine.com.backend.domains.user.repository.user.query

import beyondMedicine.com.backend.domains.user.entity.QUserEntity.userEntity
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
}
