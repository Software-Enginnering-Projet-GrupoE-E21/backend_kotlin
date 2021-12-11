package br.com.dineduc.backend.app.dto

import lombok.Builder

@Builder
data class LessonDto (
    val id : Long,
    val title: String,
)