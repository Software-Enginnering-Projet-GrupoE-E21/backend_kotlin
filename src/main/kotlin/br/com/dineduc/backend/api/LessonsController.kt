package br.com.dineduc.backend.api

import br.com.dineduc.backend.app.LessonsApplication
import br.com.dineduc.backend.app.ModulesApplication
import br.com.dineduc.backend.app.dto.ModuleDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/lesson")
class LessonsController (
    private  val lessonsApplication: LessonsApplication
        ) {

//    @GetMapping()
//    fun checkRequest() : ResponseEntity<List<ModuleDto>> {
//        val response = modulesApplication.getModules()
//        return ResponseEntity.ok(response)
//    }

    @PostMapping("/{id}")
    fun startLessonRequest(@PathVariable(value = "id")  id: Long) : ResponseEntity<Unit> {
        lessonsApplication.startLesson(id)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

    @PutMapping("/{id}")
    fun completeLessonRequest(@PathVariable(value = "id")  id: Long) : ResponseEntity<Unit> {
        lessonsApplication.completeLesson(id)
        return ResponseEntity.ok().build()
    }

}