package br.com.dineduc.backend.app

import br.com.dineduc.backend.app.dto.LoginDtoRequest
import br.com.dineduc.backend.app.dto.LoginDtoResponse
import br.com.dineduc.backend.app.dto.RegisterUserDtoRequest

interface AuthApplication {
    fun createUser(registerUserDtoRequest: RegisterUserDtoRequest) : Boolean
    fun loginUser(loginDtoRequest: LoginDtoRequest) : LoginDtoResponse
}