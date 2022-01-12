package br.com.dineduc.backend.service

import br.com.dineduc.backend.service.facade.valueObject.ModuleTestsVO
import br.com.dineduc.backend.service.facade.valueObject.ModuleVO

interface ModulesService {
    fun getModule(moduleId: Long) : ModuleVO
    fun getModules() : List<ModuleVO>
    fun getModuleTest(moduleId: Long) : ModuleTestsVO
}