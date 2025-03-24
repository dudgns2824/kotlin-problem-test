package beyondMedicine.com.backend.domains.user.repository.verifyLog

import beyondMedicine.com.backend.domains.user.dto.verifyLog.request.CreateVerifyLogRequestDto
import beyondMedicine.com.backend.domains.user.entity.QVerifyLogEntity.verifyLogEntity
import beyondMedicine.com.backend.domains.user.repositorybus.verifyLog.command.IVerifyLogDomainCommandRepositoryBus
import beyondMedicine.com.backend.domains.user.util.BaseRepository
import org.springframework.stereotype.Repository

@Repository
class VerifyLogDomainCommandRepository : BaseRepository(), IVerifyLogDomainCommandRepositoryBus {
    override fun createVerifyLog(req: CreateVerifyLogRequestDto) = queryFactory
        .insert(verifyLogEntity)
        .columns(
            verifyLogEntity.version,
            verifyLogEntity.os,
            verifyLogEntity.mode,
            verifyLogEntity.hash
        )
        .values(req.version, req.os, req.mode, req.hash)
        .execute() > 0
}