package br.com.dineduc.backend.handler.exception

import org.springframework.http.HttpStatus

class NotFoundException (
    message: String,
    desc:String
) :ApiErrorException(HttpStatus.NOT_FOUND, message,desc) {
}