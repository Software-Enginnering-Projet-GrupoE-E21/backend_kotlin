package br.com.dineduc.backend.model

import lombok.Getter
import lombok.RequiredArgsConstructor
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*
import javax.persistence.*


@Entity
data class User(
    @Id
    @GeneratedValue
    @Getter
    var id: Long,
    var firstname: String,
    var lastname: String,
    var emailAddress: String,
    var document: String,
    var birthdate: Date,
    var pass: String,
    var enabled: Boolean,
    @ManyToMany(fetch = FetchType.EAGER)
    var roles: Set<Roles>,
    @OneToOne(fetch = FetchType.LAZY)
    var organization: Organization?
) : UserDetails, BaseEntity() {

    constructor() : this(0,  "" , "", "", "", Date(), "",  true, setOf(), null ) {}

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
        return this.enabled
    }

}

