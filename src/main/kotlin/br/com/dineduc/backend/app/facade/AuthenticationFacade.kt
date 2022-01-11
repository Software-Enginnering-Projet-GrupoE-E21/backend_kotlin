package br.com.dineduc.backend.app.facade

import br.com.dineduc.backend.model.User
import org.springframework.security.core.Authentication

interface AuthenticationFacade {
    fun getAuthentication() : Authentication
    fun getPrincipal() : User?
}