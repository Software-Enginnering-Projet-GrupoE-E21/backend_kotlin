package br.com.dineduc.backend.handler.exception

import org.springframework.http.HttpStatus

abstract class ApiErrorException (
        val errorCode : HttpStatus,
        override val message: String,
        val description : String
        ): RuntimeException (message){
}