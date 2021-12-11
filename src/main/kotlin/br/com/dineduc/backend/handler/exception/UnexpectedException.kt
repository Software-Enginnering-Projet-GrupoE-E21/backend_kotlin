package br.com.dineduc.backend.handler.exception

import org.springframework.http.HttpStatus

class UnexpectedException(
    message: String,
    desc: String
) :ApiErrorException(HttpStatus.INTERNAL_SERVER_ERROR, message,desc) {
}