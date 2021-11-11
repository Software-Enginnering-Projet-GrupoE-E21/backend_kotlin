package br.com.dineduc.backend.service

import br.com.dineduc.backend.model.Organization

interface OrganizationService {
    fun createOrganization(org: Organization) : Organization
}