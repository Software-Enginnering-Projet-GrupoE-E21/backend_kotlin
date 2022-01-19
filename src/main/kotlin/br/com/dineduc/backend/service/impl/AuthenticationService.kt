package br.com.dineduc.backend.service.impl

import br.com.dineduc.backend.model.User
import br.com.dineduc.backend.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import java.util.*


@Service
class AuthenticationService (
    private val userRepository: UserRepository
        ): UserDetailsService {


    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val user:Set<User>? = userRepository.getUserByEmailAddress(username)

        user?.first()?.let{
            return it
        }
        throw UsernameNotFoundException("User not found")
    }
}