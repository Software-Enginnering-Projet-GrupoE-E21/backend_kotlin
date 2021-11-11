package br.com.dineduc.backend.app.impl

import br.com.dineduc.backend.app.AuthApplication
import br.com.dineduc.backend.app.dto.LoginDtoRequest
import br.com.dineduc.backend.app.dto.LoginDtoResponse
import br.com.dineduc.backend.app.dto.RegisterUserDtoRequest
import br.com.dineduc.backend.app.dto.RegisterUserDtoResponse
import br.com.dineduc.backend.app.mapper.AuthMapper
import br.com.dineduc.backend.model.User
import br.com.dineduc.backend.service.UserService
import br.com.dineduc.backend.service.impl.TokenService
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class AuthApplicationImpl(
    private val userService: UserService,
    private val authenticationManager: AuthenticationManager,
    private val tokenService: TokenService,
    private val passwordEncoder: PasswordEncoder,
): AuthApplication {
    override fun createUser(registerUserDtoRequest: RegisterUserDtoRequest): Boolean {
        userService.createUserStudent(AuthMapper.registerToUser(registerUserDtoRequest,passwordEncoder), registerUserDtoRequest.inviteCode)
        return true
    }

    override fun loginUser(usernamePasswordAuthenticationToken: UsernamePasswordAuthenticationToken): LoginDtoResponse {

        val authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken)

        return LoginDtoResponse("Bearer", tokenService.generateToken(authentication))
    }
}