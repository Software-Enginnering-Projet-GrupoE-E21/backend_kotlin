package br.com.dineduc.backend.app

interface LessonsApplication {
    fun startLesson(lessonId: Long)
    fun completeLesson(lessonId: Long)
}