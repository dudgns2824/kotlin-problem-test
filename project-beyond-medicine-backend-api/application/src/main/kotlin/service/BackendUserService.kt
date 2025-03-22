package service

import org.springframework.stereotype.Service
import serviceBus.IBackendUserServiceBus

@Service
class BackendUserService(
): IBackendUserServiceBus {
    override fun verifyUser() = true
}