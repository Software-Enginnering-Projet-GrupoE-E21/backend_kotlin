package br.com.dineduc.backend.app.impl

import br.com.dineduc.backend.app.LessonsApplication
import br.com.dineduc.backend.app.facade.AuthenticationFacade
import br.com.dineduc.backend.service.UserLessonsService
import br.com.dineduc.backend.service.impl.TokenService
import org.springframework.security.core.Authentication
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component


@Component
class LessonsApplicationImpl(
    private val userLessonsService: UserLessonsService,
    private val authentication: AuthenticationFacade,
) : LessonsApplication {

    override fun startLesson(lessonId: Long) {
        val currentPrincipal = authentication.getPrincipal()
        currentPrincipal?.let {
            userLessonsService.startLesson(it, lessonId)
        }
    }

    override fun completeLesson(lessonId: Long) {
        val currentPrincipal = authentication.getPrincipal()
        currentPrincipal?.let {
            userLessonsService.finishLesson(it, lessonId)
        }
    }

}