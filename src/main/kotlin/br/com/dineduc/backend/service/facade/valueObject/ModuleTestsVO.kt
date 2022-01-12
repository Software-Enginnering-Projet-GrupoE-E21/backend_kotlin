package br.com.dineduc.backend.service.facade.valueObject

data class ModuleTestsVO (
    val id : Long,
    val title: String,
    val published_at: String,
    val created_at: String,
    val questions: List<QuestionVO>?
    )

data class QuestionVO (
    val id : Long,
    val question: String,
    val answer: List<AnswerVO>
        )

data class AnswerVO (
    val id : Long,
    val text: String,
    val correct : Boolean)