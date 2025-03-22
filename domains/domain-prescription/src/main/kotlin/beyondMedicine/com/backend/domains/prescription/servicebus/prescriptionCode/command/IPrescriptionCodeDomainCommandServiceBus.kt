package beyondMedicine.com.backend.domains.prescription.servicebus.prescriptionCode.command

interface IPrescriptionCodeDomainCommandServiceBus {
    // 처방코드 생성
    fun createPrescriptionCode(hospitalId: String): String

    // 처방코드 활성화
    fun activatePrescription(userId: String, prescriptionCode: String): Boolean
}