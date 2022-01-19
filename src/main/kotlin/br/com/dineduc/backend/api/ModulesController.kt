package br.com.dineduc.backend.api

import br.com.dineduc.backend.app.ModulesApplication
import br.com.dineduc.backend.app.dto.ModuleDto
import br.com.dineduc.backend.app.dto.ModuleTestDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/v1/modules")
class ModulesController (
    private  val modulesApplication: ModulesApplication
        ) {

    @GetMapping()
    fun listModules() : ResponseEntity<List<ModuleDto>> {
        val response = modulesApplication.getModules()
        return ResponseEntity.ok(response)
    }

    @GetMapping("/{id}")
    fun getModule(@PathVariable(value = "id")  id: Long) : ResponseEntity<ModuleDto> {
        val response = modulesApplication.getModule(id)
        return ResponseEntity.ok(response)
    }

    @GetMapping("/{id}/test")
    fun getTest(@PathVariable(value = "id")  id: Long) : ResponseEntity<ModuleTestDto> {
        val response = modulesApplication.getModuleTest(id)
        return ResponseEntity.ok(response)
    }

}