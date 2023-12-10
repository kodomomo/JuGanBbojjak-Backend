package com.kodomo.juganbbojjak.domain.auth.presentation.dto

import com.kodomo.juganbbojjak.domain.auth.dto.request.LoginRequest
import jakarta.validation.constraints.NotBlank

data class LoginWebRequest(

    @NotBlank
    val accountId: String,

    @NotBlank
    val password: String,
) {

    fun toDomainRequest() = LoginRequest(
        accountId = accountId,
        password = password,
    )
}