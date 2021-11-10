package br.com.dineduc.backend.repository

import br.com.dineduc.backend.model.Roles
import br.com.dineduc.backend.model.User
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface RolesRepository: CrudRepository<Roles, Long> {
    @Query("SELECT r FROM Roles r WHERE r.name like 'student-%' ")
    fun getStudentRoles(): Set<Roles>
}

