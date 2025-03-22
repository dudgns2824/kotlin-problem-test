package beyondMedicine.com.backend.domains.user.repositorybus.user.command

interface IUserDomainCommandRepositoryBus {
    fun updateUserPrescriptionCode(
        userId: String,
        prescriptionCode: String,
    ): Boolean
}
