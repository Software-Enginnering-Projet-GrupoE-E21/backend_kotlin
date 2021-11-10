package br.com.dineduc.backend.handler.exception

import org.springframework.http.HttpStatus

class RegisterErrorException (
    message: String,
    desc:String
        ) :ApiErrorException(HttpStatus.BAD_REQUEST, message,desc) {
}