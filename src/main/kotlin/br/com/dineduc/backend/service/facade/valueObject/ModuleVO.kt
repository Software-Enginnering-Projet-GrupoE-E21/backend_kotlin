package br.com.dineduc.backend.service.facade.valueObject

data class ModuleVO (
    val id : Long,
    val title: String,
    val description : String,
    val published_at: String,
    val created_at: String,
    val trail: TrailVO?,
    val banner: MediaVO?,
    val lessons: List<LessonVO>?
    )