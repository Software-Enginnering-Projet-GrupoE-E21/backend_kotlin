package br.com.dineduc.backend.service

import br.com.dineduc.backend.model.Organization
import br.com.dineduc.backend.model.User

interface UserService {
    fun createUser (user: User) : User
    fun createUserStudent (user: User, inviteCode: String) : User

}