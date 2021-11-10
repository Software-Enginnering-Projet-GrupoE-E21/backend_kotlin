package br.com.dineduc.backend.app.dto

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank


data class LoginDtoRequest(
    @field:NotBlank
    @field:Email
    val username: String,
    @field:NotBlank
    val password: String
)