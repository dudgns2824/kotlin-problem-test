import org.springframework.http.HttpStatus
import java.time.LocalDateTime

class ApiResponse {
    companion object {
        fun ok(data: Any? = null): Map<String, Any?> {
            var res = mutableMapOf<String, Any?>()
            res.put("code", HttpStatus.OK.value())
            res.put("message", "성공하였습니다.")
            res.put("timestamp", LocalDateTime.now().toString())

            if (data != null) {
                res.put("data", data)
            }

            return res
        }

        fun error(
            code: Int = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            message: Any? = null,
            path: String? = null,
            method: String? = null,
        ): Map<String, Any?> {
            var res = mutableMapOf<String, Any?>()
            res.put("code", code)
            res.put("message", message)
            res.put("timestamp", LocalDateTime.now().toString())

            if (path != null) {
                res.put("path", path)
            }
            if (method != null) {
                res.put("method", method)
            }

            return res
        }

        fun error(
            code: Int = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            byndMdcnErrorCode: Int,
            errModuleName: String,
            message: Any? = null,
            path: String? = null,
            method: String? = null,
        ): Map<String, Any?> {
            var res = mutableMapOf<String, Any?>()
            res.put("byndMdcnErrorCode", "$errModuleName-$byndMdcnErrorCode")
            res.put("code", code)
            res.put("message", message)
            res.put("timestamp", LocalDateTime.now().toString())

            if (path != null) {
                res.put("path", path)
            }
            if (method != null) {
                res.put("method", method)
            }

            return res
        }
    }
}
