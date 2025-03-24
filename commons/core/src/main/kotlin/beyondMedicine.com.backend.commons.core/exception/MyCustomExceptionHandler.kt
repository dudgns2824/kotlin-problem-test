package beyondMedicine.com.backend.commons.core.exception

import ApiResponse
import jakarta.servlet.http.HttpServletRequest
import jakarta.validation.ConstraintViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.method.annotation.HandlerMethodValidationException

@RestControllerAdvice
class MyCustomExceptionHandler {

    @ExceptionHandler(
        value = [
            ConstraintViolationException::class,
        ],
    )
    fun handleBindException(
        request: HttpServletRequest,
        e: Exception,
    ): ResponseEntity<Any> {
        request.setAttribute("beyondMedicine.error.exception", e)

        val res =
            ApiResponse.error(
                code = HttpStatus.BAD_REQUEST.value(),
                message = "${HttpStatus.BAD_REQUEST.reasonPhrase} / ${e.message} / ${e.cause} / ${e.javaClass}",
                path = request.requestURI,
                method = request.method,
            )

        return ResponseEntity(res, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(
        value = [
            ByndMdcnException::class,
        ],
    )
    fun handleByndMdcnException(
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
