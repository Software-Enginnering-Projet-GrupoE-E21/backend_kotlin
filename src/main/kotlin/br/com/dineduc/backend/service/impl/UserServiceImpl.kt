package br.com.dineduc.backend.service.impl

import br.com.dineduc.backend.app.dto.RegisterUserDtoRequest
import br.com.dineduc.backend.handler.exception.RegisterErrorException
import br.com.dineduc.backend.model.Roles
import br.com.dineduc.backend.model.User
import br.com.dineduc.backend.repository.RolesRepository
import br.com.dineduc.backend.repository.UserRepository
import br.com.dineduc.backend.service.UserService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.text.SimpleDateFormat

@Service
class UserServiceImpl (
    private val rolesRepository: RolesRepository,
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
        ) : UserService{

    override fun createUser(registerUserDtoRequest: RegisterUserDtoRequest): Boolean {
        val userExists: User? = userRepository.getUserByEmailAddressOrDocument(registerUserDtoRequest.emailAddress, registerUserDtoRequest.document)
        if (userExists != null) {
            throw RegisterErrorException("Email address or document already in use", "Register error")
        }

        val finalUser = User(0, registerUserDtoRequest.firstName, registerUserDtoRequest.lastName, registerUserDtoRequest.emailAddress,
        registerUserDtoRequest.document, SimpleDateFormat("yyyy-MM-dd").parse(registerUserDtoRequest.birthdate) , passwordEncoder.encode(registerUserDtoRequest.password),  true, getStudentRole())

        userRepository.save(finalUser)

        return true
    }

    private fun getStudentRole () : Set<Roles> {
        var roles: Set<Roles> = rolesRepository.getStudentRoles()

        if (roles.isEmpty()) {
            val tempRole = Roles("student-read")
            rolesRepository.save(tempRole)
            roles = rolesRepository.getStudentRoles()
        }
        return roles
    }
}