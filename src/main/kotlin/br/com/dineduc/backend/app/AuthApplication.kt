package br.com.dineduc.backend.app

import br.com.dineduc.backend.app.dto.LoginDtoRequest
import br.com.dineduc.backend.app.dto.LoginDtoResponse
import br.com.dineduc.backend.app.dto.RegisterUserDtoRequest
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken

interface AuthApplication {
    fun createUser(registerUserDtoRequest: RegisterUserDtoRequest) : Boolean
    fun loginUser(usernamePasswordAuthenticationToken: UsernamePasswordAuthenticationToken) : LoginDtoResponse
}