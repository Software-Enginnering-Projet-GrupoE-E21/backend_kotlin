package br.com.dineduc.backend.app

import br.com.dineduc.backend.app.dto.ModuleDto
import br.com.dineduc.backend.app.dto.ModuleTestDto

interface ModulesApplication {
    fun getModules(): List<ModuleDto>
    fun getModule(moduleId: Long) : ModuleDto
    fun getModuleTest(moduleId: Long) : ModuleTestDto
}