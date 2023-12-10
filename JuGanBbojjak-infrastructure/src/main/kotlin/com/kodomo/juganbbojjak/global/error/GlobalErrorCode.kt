package com.kodomo.juganbbojjak.global.error

import com.kodomo.juganbbojjak.common.error.ErrorProperty

enum class GlobalErrorCode(
    override val status: Int,
    override val message: String,
) : ErrorProperty {

    EXPIRED_TOKEN(401, "Token Expired"),
    INVALID_TOKEN(401, "Invalid Token"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
}