package br.com.dineduc.backend.app.dto

import lombok.Builder

@Builder
data class BannerDto(
    val alternativeText: String,
    val caption: String,
    val url: String,
    val previewUrl: String? = null,
)