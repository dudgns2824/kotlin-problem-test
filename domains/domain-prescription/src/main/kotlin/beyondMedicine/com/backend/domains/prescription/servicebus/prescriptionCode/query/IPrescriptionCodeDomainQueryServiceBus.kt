package beyondMedicine.com.backend.domains.prescription.servicebus.prescriptionCode.query

interface IPrescriptionCodeDomainQueryServiceBus {
    // 처방 코드 활성화 여부
    fun prescriptionCodeIsActivate(prescriptionCode: String): Boolean
}