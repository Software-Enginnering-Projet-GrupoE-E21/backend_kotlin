package br.com.dineduc.backend.app.dto

import lombok.Builder

@Builder
data class TrailDto (
    val id: Long,
    val title: String,
    val description: String,
    val published_at: String,
)