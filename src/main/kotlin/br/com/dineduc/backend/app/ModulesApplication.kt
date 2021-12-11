package br.com.dineduc.backend.app

import br.com.dineduc.backend.app.dto.ModuleDto

interface ModulesApplication {
    fun getModules(): List<ModuleDto>
    fun getModule(moduleId: Long) : ModuleDto
}