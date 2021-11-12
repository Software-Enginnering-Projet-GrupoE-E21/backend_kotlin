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
    //Birthdate regex YYYY-MM-DD
    @field:Pattern(regexp = "\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$")
    val birthdate: String,
    //Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character:
    @field:Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")
    val password: String,
    @field:NotBlank
    val inviteCode: String
    )