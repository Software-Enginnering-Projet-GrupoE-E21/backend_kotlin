package br.com.dineduc.backend.app.facade.impl

import br.com.dineduc.backend.app.facade.AuthenticationFacade
import br.com.dineduc.backend.model.User
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class AuthenticationFacadeImpl : AuthenticationFacade {

    override fun getAuthentication(): Authentication {
        return SecurityContextHolder.getContext().authentication
    }

    override fun getPrincipal(): User? {
        getAuthentication().principal?.let {
            return it as User
        }
        return null
    }

}