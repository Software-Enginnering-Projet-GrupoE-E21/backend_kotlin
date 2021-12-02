package br.com.dineduc.backend.service.impl

import br.com.dineduc.backend.handler.exception.RegisterErrorException
import br.com.dineduc.backend.model.Organization
import br.com.dineduc.backend.model.Roles
import br.com.dineduc.backend.model.User
import br.com.dineduc.backend.repository.OrganizationRepository
import br.com.dineduc.backend.repository.RolesRepository
import br.com.dineduc.backend.repository.UserRepository
import br.com.dineduc.backend.service.UserService
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl (
    private val rolesRepository: RolesRepository,
    private val userRepository: UserRepository,
    private val organizationRepository: OrganizationRepository
        ) : UserService{

    override fun createUser(user: User): User {
        return userRepository.save(user)
    }

    override fun createUserStudent(user: User, inviteCode: String): User {
        val organization: Organization? = organizationRepository.getOrganizationByInvitationCode(inviteCode)
        organization?.let {
            return createUserStudentOrganization(user, it)
        }
        throw RegisterErrorException("Organization is not allowed to register more users", "Organization error")
    }

    private fun createUserStudentOrganization(user: User, organization: Organization): User {
        val userExists: User? = userRepository.getUserByEmailAddressOrDocument(user.emailAddress, user.document)
        if (userExists != null) {
            throw RegisterErrorException("Email address or document already in use", "Register error")
        }

        if (user.birthdate >= Date()){
            throw RegisterErrorException("Birthdate must be before than today", "Register error")
        }

        user.organization = organization

        val totalUsers = userRepository.getTotalUsersByOrganizationId(organization)

        if(organization.enabled && totalUsers > organization.maxStudents){
            throw RegisterErrorException("Organization is not allowed to register more users", "Organization error")
        }

        user.roles = getStudentRole()

        return createUser(user)
    }

    private fun getStudentRole () : Set<Roles> {
        var roles: Set<Roles> = rolesRepository.getStudentRoles()

        if (roles.isEmpty()) {
            val tempRole = Roles("student-read")
            rolesRepository.save(tempRole)
            roles = rolesRepository.getStudentRoles()
        }
        return roles
    }
}