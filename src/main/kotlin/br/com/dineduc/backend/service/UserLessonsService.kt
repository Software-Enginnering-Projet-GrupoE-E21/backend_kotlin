package br.com.dineduc.backend.service

import br.com.dineduc.backend.model.Lesson
import br.com.dineduc.backend.model.User

interface UserLessonsService {
    fun startLesson(user: User, lessonId: Long)
    fun finishLesson(user: User,lessonId: Long)
    fun getPendingLessons(user: User):Set<Lesson>
    fun getCompleteLessons(user: User):Set<Lesson>
}