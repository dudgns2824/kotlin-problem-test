package beyondMedicine.com.backend.domains.prescription.repositorybus.prescriptionCode.query

interface IPrescriptionCodeDomainQueryRepositoryBus {
    // 처방 코드 활성화 여부
    fun prescriptionCodeIsActivate(prescriptionCode: String): Boolean
}