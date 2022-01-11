package br.com.dineduc.backend.repository

import br.com.dineduc.backend.model.Lesson
import br.com.dineduc.backend.model.User
import br.com.dineduc.backend.model.UserLessons
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserLessonsRepository : CrudRepository<UserLessons, Long>{

    @Query("SELECT ul FROM UserLessons ul WHERE ul.lesson = :lesson and ul.user = :user ")
    fun getUserLessonsByLesson(user : User, lesson: Lesson): UserLessons?

    @Query("SELECT ul FROM UserLessons ul WHERE ul.user = :user and ul.completed = true")
    fun getCompletedLessons(user : User) : Set<UserLessons>

    @Query("SELECT ul FROM UserLessons ul WHERE ul.user = :user and ul.completed = false")
    fun getPendingLessons(user : User) : Set<UserLessons>
}