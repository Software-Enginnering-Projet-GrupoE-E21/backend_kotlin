package br.com.dineduc.backend.app.dto

import lombok.Builder

@Builder
data class LoginDtoResponse(
    val type: String,
    val token: String,
)