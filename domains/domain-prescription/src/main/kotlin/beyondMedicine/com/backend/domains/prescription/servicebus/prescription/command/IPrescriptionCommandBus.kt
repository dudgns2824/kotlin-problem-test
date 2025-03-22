package beyondMedicine.com.backend.domains.prescription.servicebus.prescription.command

interface IPrescriptionCommandBus {
    // 처방코드 생성
    fun createPrescriptionCode(hospitalId: String): String
}