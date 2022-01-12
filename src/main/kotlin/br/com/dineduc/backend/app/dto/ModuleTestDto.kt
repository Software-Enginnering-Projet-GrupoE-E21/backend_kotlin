package br.com.dineduc.backend.app.dto

import lombok.Builder

@Builder
data class ModuleTestDto (
val id : Long,
val title: String,
val published_at: String,
val questions: List<QuestionDto>?
)

@Builder
data class QuestionDto (
    val id : Long,
    val question: String,
    val answer: List<AnswerDto>
)

@Builder
data class AnswerDto (
    val id : Long,
    val text: String,
    )