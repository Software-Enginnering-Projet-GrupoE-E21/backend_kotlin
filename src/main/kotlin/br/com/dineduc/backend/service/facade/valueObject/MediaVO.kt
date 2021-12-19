package br.com.dineduc.backend.service.facade.valueObject

data class MediaVO (
    val id: Long,
    val name: String,
    val alternativeText: String,
    val caption: String,
    val width: Long? = null,
    val height: Long? = null,
    val hash: String,
    val ext: String,
    val mime: String,
    val size: Double,
    val url: String,
    val previewUrl: String? = null,
    val provider: String,
    val provider_metadata: String? = null,
    val created_at: String,
    val updated_at: String
)