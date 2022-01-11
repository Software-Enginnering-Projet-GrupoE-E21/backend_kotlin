package br.com.dineduc.backend.handler.exception

import org.springframework.http.HttpStatus

class LessonErrorException (
    message: String,
    desc:String
) :ApiErrorException(HttpStatus.ALREADY_REPORTED, message,desc) {
}