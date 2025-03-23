package beyondMedicine.com.backend.domains.prescription.util

object PrescriptionCodeUtil {
    const val prescriptionCodeAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    const val prescriptionCodeNumber = "0123456789"
    fun createPrescriptionCode() = (buildString {
        repeat(4) { append(prescriptionCodeAlphabet.random()) }
        repeat(4) { append(prescriptionCodeNumber.random()) }
    }).toList().shuffled().joinToString()
}