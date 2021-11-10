package br.com.dineduc.backend.app.dto

import java.util.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern

data class RegisterUserDtoRequest(
    @field:NotBlank
    val firstName: String,
    @field:NotBlank
    val lastName: String,
    @field:NotBlank
    val emailAddress: String,
    @field:NotBlank
    val document: String,
    @field:Pattern(regexp = "\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$")
    val birthdate: String,
    @field:NotBlank
    val password: String,
    @field:NotBlank
    val inviteCode: String
    )