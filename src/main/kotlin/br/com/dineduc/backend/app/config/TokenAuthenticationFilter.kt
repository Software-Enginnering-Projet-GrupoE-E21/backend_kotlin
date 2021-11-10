package br.com.dineduc.backend.app.config

import br.com.dineduc.backend.model.User
import br.com.dineduc.backend.repository.UserRepository
import br.com.dineduc.backend.service.impl.TokenService
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import java.util.*
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class TokenAuthenticationFilter (
    private val userRepository: UserRepository,
    private val tokenService: TokenService,
        ): OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val tokenFromHeader = getTokenFromHeader(request)
        val tokenValid: Boolean = tokenService.isTokenValid(tokenFromHeader)
        if (tokenValid) {
            authenticate(tokenFromHeader!!)
        }

        filterChain.doFilter(request, response)
    }

    private fun authenticate(tokenFromHeader: String) {
        val tokenId: Int? = tokenService.getTokenId(tokenFromHeader)
        tokenId?.let {
            val optionalUser: Optional<User> = userRepository.findById(it.toLong())
            if (optionalUser.isPresent) {
                val user: User = optionalUser.get()
                val usernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken(user, null, user.roles)
                SecurityContextHolder.getContext().authentication = usernamePasswordAuthenticationToken
            }
        }

    }

    private fun getTokenFromHeader(request: HttpServletRequest): String? {
        val token = request.getHeader("Authorization")
        return if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
            null
        } else token.substring(7, token.length)
    }
}