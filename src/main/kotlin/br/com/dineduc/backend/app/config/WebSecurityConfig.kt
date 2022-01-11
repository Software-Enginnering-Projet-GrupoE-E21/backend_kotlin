package br.com.dineduc.backend.app.config

import br.com.dineduc.backend.repository.UserRepository
import br.com.dineduc.backend.service.impl.AuthenticationService
import br.com.dineduc.backend.service.impl.TokenService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


@Configuration
@EnableWebSecurity
class WebSecurityConfig (
     val authenticationService: AuthenticationService,
     val userRepository: UserRepository,
     val tokenService: TokenService
        ): WebSecurityConfigurerAdapter() {

    @Bean
    fun encoder() : PasswordEncoder {
        return BCryptPasswordEncoder()
    }



    @Bean
    @Throws(Exception::class)
    override fun authenticationManager(): AuthenticationManager? {
        return super.authenticationManager()
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.userDetailsService(authenticationService)?.passwordEncoder(encoder())
    }

    override fun configure(http: HttpSecurity?) {
        if(http == null) return
        http.authorizeRequests()
            .antMatchers(HttpMethod.POST, "/api/v1/auth/register").permitAll()
            .antMatchers(HttpMethod.POST, "/api/v1/auth/login").permitAll()
            .anyRequest().authenticated()
            .and().csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and().addFilterBefore(TokenAuthenticationFilter(userRepository,tokenService), UsernamePasswordAuthenticationFilter::class.java);

    }

}