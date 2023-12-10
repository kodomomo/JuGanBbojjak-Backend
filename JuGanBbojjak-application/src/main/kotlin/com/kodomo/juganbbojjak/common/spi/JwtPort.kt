package com.kodomo.juganbbojjak.common.spi

import com.kodomo.juganbbojjak.domain.auth.dto.response.TokenResponse
import java.util.UUID

interface JwtPort {
    fun generateTokens(id: UUID): TokenResponse
}