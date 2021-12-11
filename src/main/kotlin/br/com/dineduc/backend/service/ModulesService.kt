package br.com.dineduc.backend.service

import br.com.dineduc.backend.service.facade.valueObject.ModuleVO

interface ModulesService {
    fun getModule(moduleId: Long) : ModuleVO
    fun getModules() : List<ModuleVO>
}