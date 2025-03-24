package beyondMedicine.com.backend.serviceBus.prescription.command

interface IBackendPrescriptionCommandServiceBus {
    // 처방코드 생성
    fun createPrescriptionCode(hospitalId: String): String

    // 처방코드 활성화
    fun activatePrescriptionCode(
        userId: String,
        prescriptionCode: String,
    ): Boolean
}
