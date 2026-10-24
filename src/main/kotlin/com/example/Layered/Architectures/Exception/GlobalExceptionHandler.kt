package com.example.Layered.Architectures.Exception

import com.example.Layered.Architectures.DTOS.Response.ApiResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException

@RestControllerAdvice
class GlobalExceptionHandler {

    // bad or missing JSON body
    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleBadBody(e: HttpMessageNotReadableException): ResponseEntity<ApiResponse<Nothing>> =
        ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(ApiResponse(false, "Invalid or missing request body!"))

    // bad path value, like /user/abc
    @ExceptionHandler(MethodArgumentTypeMismatchException::class)
    fun handleBadParam(e: MethodArgumentTypeMismatchException): ResponseEntity<ApiResponse<Nothing>> =
        ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(ApiResponse(false, "Invalid value for '${e.name}'"))

    // anything else
    @ExceptionHandler(Exception::class)
    fun handleOther(e: Exception): ResponseEntity<ApiResponse<Nothing>> =
        ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(ApiResponse(false, "Something went wrong!"))
}