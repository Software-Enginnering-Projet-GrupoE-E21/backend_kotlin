package br.com.dineduc.backend.app.impl

import br.com.dineduc.backend.app.ModulesApplication
import br.com.dineduc.backend.app.dto.ModuleDto
import br.com.dineduc.backend.app.mapper.ModuleMapper
import br.com.dineduc.backend.service.ModulesService
import org.springframework.stereotype.Component

@Component
class ModulesApplicationImpl (
    private val modulesService: ModulesService
        ) : ModulesApplication{
    override fun getModules(): List<ModuleDto> {
        val listVO = modulesService.getModules()
        return (listVO.map { ModuleMapper.moduleDtoFromModuleVO(it) }).toList()
    }

    override fun getModule(moduleId: Long): ModuleDto {
        val module = modulesService.getModule(moduleId)
        return ModuleMapper.moduleDtoFromModuleVO(module)
    }


}