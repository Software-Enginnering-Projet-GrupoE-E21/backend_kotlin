package br.com.dineduc.backend.repository

import br.com.dineduc.backend.model.Organization
import br.com.dineduc.backend.model.User
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface OrganizationRepository : CrudRepository<Organization,Long> {
    @Query("SELECT o FROM Organization o WHERE o.invitationCode = :invitationCode")
    fun getOrganizationByInvitationCode(@Param("invitationCode") invitationCode: String?): Organization?

}
