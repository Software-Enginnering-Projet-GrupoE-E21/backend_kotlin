package br.com.dineduc.backend.model

import lombok.Getter
import lombok.RequiredArgsConstructor
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*
import javax.persistence.*


@Entity
@RequiredArgsConstructor
data class User(
    @Id
    @GeneratedValue
    @Getter
    val id: Long,
    val firstname: String,
    val lastname: String,
    val emailAddress: String,
    val document: String,
    val birthdate: Date,
    val pass: String,
    val enabled: Boolean,
    @ManyToMany(fetch = FetchType.EAGER)
    val roles: Set<Roles>
) : UserDetails {

    constructor() : this(0,  "" , "", "", "", Date(), "",  true, setOf() ) {}

    override fun getAuthorities(): Collection<GrantedAuthority?> {
        return this.roles
    }

    override fun getPassword(): String {
        return this.pass
    }


    override fun getUsername(): String {
        return this.emailAddress
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }



}

