package beyondMedicine.com.backend.domains.prescription.util

object PrescriptionCodeUtil {
    private const val PRESCRIPTION_CODE_ALPHABET_FORMAT = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    private const val PRESCRIPTION_CODE_NUMBER_FORMAT = "0123456789"

    fun createPrescriptionCode() =
        (
            buildString {
                repeat(4) {
                    append(PRESCRIPTION_CODE_ALPHABET_FORMAT.random())
                    append(PRESCRIPTION_CODE_NUMBER_FORMAT.random())
                }
            }
        ).toList().joinToString("")
}
