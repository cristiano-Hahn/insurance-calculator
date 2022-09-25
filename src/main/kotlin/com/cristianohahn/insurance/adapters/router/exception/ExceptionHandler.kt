package com.cristianohahn.insurance.adapters.router.exception

import com.cristianohahn.insurance.core.risk.exception.CalculateRiskInformationNotValidException
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

    @ExceptionHandler(value = [Exception::class])
    protected fun handleConflict(
        ex: CalculateRiskInformationNotValidException?, request: WebRequest?
    ): ResponseEntity<Any?>? {
        return handleExceptionInternal(
            ex!!, ExceptionResponse(ex.message),
            HttpHeaders(), HttpStatus.BAD_REQUEST, request!!
        )
    }
}