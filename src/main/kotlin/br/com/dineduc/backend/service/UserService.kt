package br.com.dineduc.backend.service

import br.com.dineduc.backend.app.dto.RegisterUserDtoRequest

interface UserService {
    fun createUser (registerUserDtoRequest: RegisterUserDtoRequest) : Boolean

}