package beyondMedicine.com.backend.domains.user.servicebus.user.command

interface IUserDomainCommandServiceBus {
    fun updateUserPrescriptionCode(
        userId: String,
        prescriptionCode: String,
    ): Boolean
}
