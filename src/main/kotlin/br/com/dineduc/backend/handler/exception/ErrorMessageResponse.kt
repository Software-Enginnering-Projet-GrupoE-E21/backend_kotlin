package br.com.dineduc.backend.handler.exception

import java.util.*

class ErrorMessageResponse (
    val statusCode : Int,
    val timestamp : Date,
    val message: ArrayList<String>,
    val description : String
)
