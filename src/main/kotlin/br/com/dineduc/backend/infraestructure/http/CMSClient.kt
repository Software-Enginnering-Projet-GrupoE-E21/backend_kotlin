package br.com.dineduc.backend.infraestructure.http

import br.com.dineduc.backend.service.facade.valueObject.ModulesVO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping


@FeignClient(name="\${dineduc.cms.name}", url="\${dineduc.cms.base-url}")
interface CMSClient {
    @GetMapping("\${dineduc.cms. modules-path-url}")
    fun getModules() : ModulesVO
}