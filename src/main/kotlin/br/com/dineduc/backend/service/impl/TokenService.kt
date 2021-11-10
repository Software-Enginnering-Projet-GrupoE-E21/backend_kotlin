package br.com.dineduc.backend.service.impl

import br.com.dineduc.backend.model.User
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service
import java.util.*


@Service
class TokenService {
    @Value("\${jwt.expiration}")
    private val expiration: String? = null

    @Value("\${jwt.secret}")
    private val secret: String? = null
    fun generateToken(authentication: Authentication): String {
        val usuario: User = authentication.principal as User
        val now = Date()
        val exp = Date(now.getTime() + expiration!!.toLong())
        return Jwts.builder().setIssuer("DinEduc")
            .setSubject(usuario.id.toString())
            .setIssuedAt(Date())
            .setExpiration(exp)
            .signWith(SignatureAlgorithm.HS256, secret).compact()
    }
    fun isTokenValid(token: String?): Boolean {
        return try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun getTokenId(token: String?): Int? {
        val body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).body
        return Integer.valueOf(body.subject)
    }

}