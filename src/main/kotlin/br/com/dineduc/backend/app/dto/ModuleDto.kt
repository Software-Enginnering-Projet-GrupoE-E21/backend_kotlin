package br.com.dineduc.backend.app.dto

import lombok.Builder

@Builder
data class ModuleDto (
    val id : Long,
    val title: String,
    val description : String,
    val published_at: String,
    val trail: TrailDto?,
    val banner: MediaDto?,
    val lessons: List<LessonDto>?
)