package br.com.dineduc.backend.service.facade.valueObject

data class LessonVO(
    val id: Long,
    val title: String,
    val content: String,
    val description: String,
    val banner: MediaVO?,
    val video: MediaVO?,

)