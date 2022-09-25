package com.cristianohahn.insurance.controller.exception

import com.cristianohahn.insurance.service.exception.RiskProfileInformationNotValidException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler


@ControllerAdvice
class ExceptionHandler : ResponseEntityExceptionHandler() {

    data class ExceptionResponse(val errorMessage: String?)

    @ExceptionHandler(value = [RiskProfileInformationNotValidException::class])
    protected fun handleRiskProfileInformationNotValidException(
        ex: RiskProfileInformationNotValidException?, request: WebRequest?
    ): ResponseEntity<Any?>? {
        return handleExceptionInternal(
            ex!!, ExceptionResponse(ex.message),
            HttpHeaders(), HttpStatus.BAD_REQUEST, request!!
        )
    }

    @ExceptionHandler(value = [Exception::class])
    protected fun handleGenericException(
        ex: RiskProfileInformationNotValidException?, request: WebRequest?
    ): ResponseEntity<Any?>? {
        return handleExceptionInternal(
            ex!!, ExceptionResponse(ex.message),
            HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request!!
        )
    }
}