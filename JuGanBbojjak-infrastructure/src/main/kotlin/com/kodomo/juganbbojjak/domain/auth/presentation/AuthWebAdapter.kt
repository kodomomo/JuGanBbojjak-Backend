package com.kodomo.juganbbojjak.domain.auth.presentation

import com.kodomo.juganbbojjak.domain.auth.dto.response.TokenResponse
import com.kodomo.juganbbojjak.domain.auth.presentation.dto.LoginWebRequest
import com.kodomo.juganbbojjak.domain.auth.usecase.LoginUseCase
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/auth")
@RestController
class AuthWebAdapter(
    private val loginUseCase: LoginUseCase,
) {

    @PostMapping("login")
    fun login(@RequestBody @Valid request: LoginWebRequest): TokenResponse =
        loginUseCase.execute(request.toDomainRequest())
}