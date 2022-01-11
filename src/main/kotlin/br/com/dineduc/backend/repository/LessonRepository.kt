package br.com.dineduc.backend.repository

import br.com.dineduc.backend.model.Lesson
import br.com.dineduc.backend.model.User
import br.com.dineduc.backend.model.UserLessons
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface LessonRepository : CrudRepository<Lesson, Long>{

}