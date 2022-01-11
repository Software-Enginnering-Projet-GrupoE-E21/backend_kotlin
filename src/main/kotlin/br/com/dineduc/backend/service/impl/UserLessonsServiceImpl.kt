package br.com.dineduc.backend.service.impl

import br.com.dineduc.backend.handler.exception.LessonErrorException
import br.com.dineduc.backend.handler.exception.NotFoundException
import br.com.dineduc.backend.model.Lesson
import br.com.dineduc.backend.model.User
import br.com.dineduc.backend.model.UserLessons
import br.com.dineduc.backend.repository.LessonRepository
import br.com.dineduc.backend.repository.UserLessonsRepository
import br.com.dineduc.backend.service.UserLessonsService
import org.springframework.stereotype.Service

@Service
class UserLessonsServiceImpl (
    private val userLessonsRepository: UserLessonsRepository,
    private val lessonRepository: LessonRepository,
        ) : UserLessonsService {
    override fun startLesson(user: User, lessonId: Long) {
        val lesson = lessonRepository.findById(lessonId)

        if(lesson.isEmpty){
            throw NotFoundException("Lesson not found", "Lesson not found with id $lessonId")
        }

        var userLesson: UserLessons? = userLessonsRepository.getUserLessonsByLesson(user, lesson.get())
        if (userLesson == null) {
            userLesson = UserLessons()
            userLesson.user = user
            userLesson.lesson = lesson.get()
            userLesson.completed = false
            userLessonsRepository.save(userLesson)
        } else {
            throw LessonErrorException("Lesson already started", "No changes applied")
        }
    }

    override fun finishLesson(user: User,lessonId: Long) {
        val lesson = lessonRepository.findById(lessonId)

        if(lesson.isEmpty){
            throw NotFoundException("Lesson not found", "Lesson not found with id $lessonId")
        }

        val userLesson : UserLessons? = userLessonsRepository.getUserLessonsByLesson(user, lesson.get())
        userLesson?.let {
            it.completed = true
            userLessonsRepository.save(it)
        } ?: run {
            var newUserLessons = UserLessons()
            newUserLessons.user = user
            newUserLessons.lesson = lesson.get()
            newUserLessons.completed = true
            userLessonsRepository.save(newUserLessons)
        }

    }

    override fun getPendingLessons(user: User): Set<Lesson> {
        val userLessons: Set<UserLessons> = userLessonsRepository.getPendingLessons(user)
        val lessons = arrayListOf<Lesson>()
        userLessons.forEach {
            it.lesson?.let { itLesson -> lessons.add(itLesson) }
        }

        return lessons.toSet()
    }

    override fun getCompleteLessons(user: User): Set<Lesson> {
        val userLessons: Set<UserLessons> = userLessonsRepository.getCompletedLessons(user)
        val lessons = arrayListOf<Lesson>()
        userLessons.forEach {
            it.lesson?.let { itLesson -> lessons.add(itLesson) }
        }

        return lessons.toSet()
    }
}