package beyondMedicine.com.backend.service.user.query

import org.springframework.stereotype.Service
import beyondMedicine.com.backend.serviceBus.user.query.IBackendUserQueryServiceBus

@Service
class BackendUserQueryService(
): IBackendUserQueryServiceBus {
    override fun verifyUser() = true
}