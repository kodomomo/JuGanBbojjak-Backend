package com.kodomo.juganbbojjak.domain.auth.usecase

import com.kodomo.juganbbojjak.common.annotation.UseCase
import com.kodomo.juganbbojjak.common.spi.JwtPort
import com.kodomo.juganbbojjak.common.spi.SecurityPort
import com.kodomo.juganbbojjak.domain.auth.dto.request.LoginRequest
import com.kodomo.juganbbojjak.domain.auth.dto.response.TokenResponse
import com.kodomo.juganbbojjak.domain.auth.exception.InvalidPasswordException
import com.kodomo.juganbbojjak.domain.user.exception.UserNotFoundException
import com.kodomo.juganbbojjak.domain.user.spi.QueryUserPort

@UseCase
class LoginUseCase(
    private val queryUserPort: QueryUserPort,
    private val jwtPort: JwtPort,
    private val securityPort: SecurityPort,
) {

    fun execute(request: LoginRequest): TokenResponse {
        val user = queryUserPort.queryUserByAccountId(request.accountId) ?: throw UserNotFoundException

        if (!securityPort.matchPassword(request.password, user.password)) {
            throw InvalidPasswordException
        }

        return jwtPort.generateTokens(user.id)
    }
}