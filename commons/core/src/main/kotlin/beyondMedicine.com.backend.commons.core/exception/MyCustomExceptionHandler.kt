package beyondMedicine.com.backend.commons.core.exception

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class MyCustomExceptionHandler {
    @ExceptionHandler(
        value = [
            ByndMdcnException::class,
        ],
    )
    fun handleHmcException(
        request: HttpServletRequest,
        e: ByndMdcnException,
    ): ResponseEntity<Any> {
        request.setAttribute("beyondMedicine.error.exception", e)

        val res =
            ApiResponse.error(
                code = e.httpStatusCode,
                byndMdcnErrorCode = e.byndMdcnErrorCode,
                errModuleName = e.errModuleName,
                message = "${e.message}",
                path = request.requestURI,
                method = request.method,
            )

        return ResponseEntity(res, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}
