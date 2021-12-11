package br.com.dineduc.backend.api

import br.com.dineduc.backend.app.ModulesApplication
import br.com.dineduc.backend.app.dto.ModuleDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/modules")
class ModulesController (
    private  val modulesApplication: ModulesApplication
        ) {

    @GetMapping()
    fun checkRequest() : ResponseEntity<List<ModuleDto>> {
        val response = modulesApplication.getModules()
        return ResponseEntity.ok(response)
    }

    @GetMapping("/{id}")
    fun checkRequest(@PathVariable(value = "id")  id: Long) : ResponseEntity<ModuleDto> {
        val response = modulesApplication.getModule(id)
        return ResponseEntity.ok(response)
    }

}