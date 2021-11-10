package br.com.dineduc.backend.model

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import org.springframework.security.core.GrantedAuthority
import javax.persistence.*


@Entity
data class Roles(
    @Id
    @GeneratedValue
    private val id: Long,
    private val name: String ): GrantedAuthority{
    constructor(name: String) : this(0, name) {

    }
    constructor() : this(0, "")

    override fun getAuthority() : String {
        return this.name;
    }
}

