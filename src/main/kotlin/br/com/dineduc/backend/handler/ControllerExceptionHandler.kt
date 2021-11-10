package br.com.dineduc.backend.handler

import br.com.dineduc.backend.handler.exception.ApiErrorException
import br.com.dineduc.backend.handler.exception.ErrorMessageResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.AuthenticationException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.*
import javax.validation.ConstraintViolationException


@ControllerAdvice
class ControllerExceptionHandler {

    @ExceptionHandler(ApiErrorException::class)
    fun apiErrorException (apiErrorException: ApiErrorException) : ResponseEntity<ErrorMessageResponse>{
        val errorMessageResponse = ErrorMessageResponse(apiErrorException.errorCode.value(), Date(), arrayListOf<String>(apiErrorException.message) , apiErrorException.description)
        return ResponseEntity(errorMessageResponse, apiErrorException.errorCode)
    }

    @ExceptionHandler(ConstraintViolationException::class)
    fun onConstraintValidationException(e: ConstraintViolationException): ResponseEntity<ErrorMessageResponse> {
        val error = ErrorMessageResponse(HttpStatus.BAD_REQUEST.value(), Date(), ArrayList(), "Invalid request")
        for (violation in e.constraintViolations) {
            error.message.add(violation.propertyPath.toString() + " - " + violation.message)
        }

        return ResponseEntity(error,HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun onMethodArgumentNotValidException( e: MethodArgumentNotValidException): ResponseEntity<ErrorMessageResponse> {
        val error = ErrorMessageResponse(HttpStatus.BAD_REQUEST.value(), Date(), ArrayList(), "Invalid request")
        for (fieldError in e.bindingResult.fieldErrors) {
            error.message.add( fieldError.field + " - "+ fieldError.defaultMessage)
        }
        return ResponseEntity(error,HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(AuthenticationException::class)
    fun onAuthenticationException( e: AuthenticationException): ResponseEntity<ErrorMessageResponse> {
        val error = ErrorMessageResponse(HttpStatus.UNAUTHORIZED.value(), Date(), arrayListOf<String>(e.message.toString()), "Username or password is invalid")

        return ResponseEntity(error,HttpStatus.UNAUTHORIZED)
    }
}