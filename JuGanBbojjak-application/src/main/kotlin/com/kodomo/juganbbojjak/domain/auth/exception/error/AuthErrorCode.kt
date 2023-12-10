package com.kodomo.juganbbojjak.domain.auth.exception.error

import com.kodomo.juganbbojjak.common.error.ErrorProperty

enum class AuthErrorCode(
    override val status: Int,
    override val message: String
) : ErrorProperty {

    INVALID_PASSWORD(401, "Invalid Password")
}