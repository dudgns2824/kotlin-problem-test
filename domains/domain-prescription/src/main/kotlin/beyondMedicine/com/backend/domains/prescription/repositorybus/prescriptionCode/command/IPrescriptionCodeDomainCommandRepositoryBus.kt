package beyondMedicine.com.backend.domains.prescription.repositorybus.prescriptionCode.command

interface IPrescriptionCodeDomainCommandRepositoryBus {
    // 처방코드 생성
    fun createPrescriptionCode(hospitalId: String): String

    // 처방코드 활성화
    fun activatePrescriptionCode(prescriptionCode: String): Boolean

    // 처방코드 삭제
    fun deletePrescriptionCode(prescriptionCode: String): Boolean
}
