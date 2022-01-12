package br.com.dineduc.backend.infraestructure.http

import br.com.dineduc.backend.service.facade.valueObject.ModuleTestsVO
import br.com.dineduc.backend.service.facade.valueObject.ModuleVO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable


@FeignClient(name="\${dineduc.cms.name}", url="\${dineduc.cms.base-url}")
interface CMSClient {
    @GetMapping("\${dineduc.cms.modules-path-url}")
    fun getModules() : List<ModuleVO>

    @GetMapping("\${dineduc.cms.modules-path-url}/{id}")
    fun getModule(@PathVariable(value = "id") id: Long) : ModuleVO

    @GetMapping("\${dineduc.cms.module-tests-path-url}?module={id}")
    fun getModuleTest(@PathVariable(value = "id") id: Long) : List<ModuleTestsVO>
}