package br.com.dineduc.backend.app.impl

import br.com.dineduc.backend.app.AuthApplication
import br.com.dineduc.backend.app.dto.LoginDtoRequest
import br.com.dineduc.backend.app.dto.LoginDtoResponse
import br.com.dineduc.backend.app.dto.RegisterUserDtoRequest
import br.com.dineduc.backend.service.UserService
import br.com.dineduc.backend.service.impl.TokenService
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Component

@Component
class AuthApplicationImpl(
    private val userService: UserService,
    private val authenticationManager: AuthenticationManager,
    private val tokenService: TokenService
): AuthApplication {
    override fun createUser(registerUserDtoRequest: RegisterUserDtoRequest): Boolean {
        return userService.createUser(registerUserDtoRequest)
    }

    override fun loginUser(loginDtoRequest: LoginDtoRequest): LoginDtoResponse {
        val usernamePasswordAuthenticationToken =
            UsernamePasswordAuthenticationToken(loginDtoRequest.username, loginDtoRequest.password)

        val authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken)

        val token: String = tokenService.generateToken(authentication)

        return LoginDtoResponse("Bearer", token)
    }
}