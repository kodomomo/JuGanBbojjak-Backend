package com.kodomo.juganbbojjak.domain.user.exception.error

import com.kodomo.juganbbojjak.common.error.ErrorProperty

enum class UserErrorCode(
    override val status: Int,
    override val message: String,
) : ErrorProperty {
}