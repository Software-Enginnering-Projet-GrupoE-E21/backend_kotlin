package br.com.dineduc.backend.app.mapper

import br.com.dineduc.backend.app.dto.LoginDtoRequest
import br.com.dineduc.backend.app.dto.RegisterUserDtoRequest
import br.com.dineduc.backend.app.dto.RegisterUserDtoResponse
import br.com.dineduc.backend.infraestructure.ses.Mail
import br.com.dineduc.backend.model.User
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import java.text.SimpleDateFormat

class AuthMapper {
    companion object {
        fun loginToUserPasswordAuthentication (loginDtoRequest: LoginDtoRequest) : UsernamePasswordAuthenticationToken {
            return UsernamePasswordAuthenticationToken(loginDtoRequest.username, loginDtoRequest.password)
        }

        fun registerToUser (registerUserDtoRequest: RegisterUserDtoRequest, passwordEncoder: PasswordEncoder) : User {
            return User(0, registerUserDtoRequest.firstName, registerUserDtoRequest.lastName,
                registerUserDtoRequest.emailAddress, registerUserDtoRequest.document,
                SimpleDateFormat("yyyy-MM-dd").parse(registerUserDtoRequest.birthdate) ,
                passwordEncoder.encode(registerUserDtoRequest.password),  true, setOf(),
                null)
        }

        fun registerUserToMail(user: User) : Mail {
            var model: HashMap<String, Any> = HashMap()
            model["name"] = user.firstname
            model["link"] = "https://google.com.br"
            return Mail().apply {
                to = user.emailAddress
                from = "no-reply@dineduc.com.br"
                subject = "Cadastro Din Educ"
                model = model
            }
        }

    }
}