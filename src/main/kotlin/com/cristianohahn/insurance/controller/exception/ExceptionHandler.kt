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

    @ExceptionHandler(value = [Exception::class])
    protected fun handleConflict(
        ex: RiskProfileInformationNotValidException?, request: WebRequest?
    ): ResponseEntity<Any?>? {
        return handleExceptionInternal(
            ex!!, ExceptionResponse(ex.message),
            HttpHeaders(), HttpStatus.BAD_REQUEST, request!!
        )
    }
}