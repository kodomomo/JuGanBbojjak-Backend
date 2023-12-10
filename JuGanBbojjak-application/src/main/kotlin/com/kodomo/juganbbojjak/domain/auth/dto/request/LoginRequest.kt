package com.kodomo.juganbbojjak.domain.auth.dto.request

data class LoginRequest(
    val accountId: String,
    val password: String,
)
