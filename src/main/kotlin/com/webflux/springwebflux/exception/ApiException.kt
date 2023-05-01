package com.webflux.springwebflux.exception

import com.webflux.springwebflux.utils.ResponseDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class ApiException {
    @ExceptionHandler(value = [RuntimeException::class])
    fun internalServerError(exceptionHandler: GenericExceptionHandler): ResponseEntity<ResponseDTO> {
        val body = GenericExceptionHandler(exceptionMessage = exceptionHandler.message.toString())
        val response = ResponseDTO(
                message = body.exceptionMessage,
                status = body.httpStatus,
                payload = null
        )
        return ResponseEntity.internalServerError().body(response)
    }

    @ExceptionHandler(value = [GenericExceptionHandler::class])
    fun badRequest(exceptionHandler: GenericExceptionHandler): ResponseEntity<ResponseDTO> {
        val body = GenericExceptionHandler(exceptionMessage = exceptionHandler.message.toString(), httpStatus = HttpStatus.BAD_REQUEST)
        val response = ResponseDTO(
                message = body.exceptionMessage,
                status = body.httpStatus,
                payload = null
        )
        return ResponseEntity.internalServerError().body(response)

    }
}