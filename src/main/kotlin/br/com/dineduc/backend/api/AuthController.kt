package br.com.dineduc.backend.api

import br.com.dineduc.backend.app.AuthApplication
import br.com.dineduc.backend.app.dto.LoginDtoRequest
import br.com.dineduc.backend.app.dto.LoginDtoResponse
import br.com.dineduc.backend.app.dto.RegisterUserDtoRequest
import br.com.dineduc.backend.app.mapper.AuthMapper
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/v1/auth")
class AuthController (
    private val authApplication: AuthApplication,
        ) {


    @PostMapping("/register")
    fun create(@Valid @RequestBody registerUserDtoRequest: RegisterUserDtoRequest):
            ResponseEntity<Boolean> {
        val response = authApplication.createUser(registerUserDtoRequest)
        return ResponseEntity.ok(response)
    }

    @PostMapping("/login")
    fun login(@Valid @RequestBody loginDtoRequest: LoginDtoRequest):
            ResponseEntity<LoginDtoResponse> {
        val response = authApplication.loginUser(AuthMapper.loginToUserPasswordAuthentication(loginDtoRequest))
        return ResponseEntity.ok(response)
    }

    @GetMapping("/check")
    fun checkRequest() : ResponseEntity<Boolean>  {
        return ResponseEntity.ok(true)
    }


}