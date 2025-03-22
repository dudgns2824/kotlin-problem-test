package beyondMedicine.com.backend.domains.prescription.servicebus.prescription.query

interface IPrescriptionQueryBus {
    // 처방 코드 활성화 여부
    fun prescriptionCodeIsActivate(prescriptionCode: String): Boolean
}