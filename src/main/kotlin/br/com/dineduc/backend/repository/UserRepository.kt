package br.com.dineduc.backend.repository

import br.com.dineduc.backend.model.Organization
import br.com.dineduc.backend.model.User
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.emailAddress = :emailAddress")
    fun getUserByEmailAddress(@Param("emailAddress") emailAddress: String?): User?

    @Query("SELECT u FROM User u WHERE u.emailAddress = :emailAddress or u.document = :document")
    fun getUserByEmailAddressOrDocument(@Param("emailAddress") emailAddress: String?, @Param("document") document: String?): User?

    @Query("SELECT count(u.id) FROM User u WHERE u.organization = :organization")
    fun getTotalUsersByOrganizationId(organization: Organization) : Long
}