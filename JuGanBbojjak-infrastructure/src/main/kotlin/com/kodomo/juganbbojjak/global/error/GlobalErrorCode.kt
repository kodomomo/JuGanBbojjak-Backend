package com.kodomo.juganbbojjak.global.error

import com.kodomo.juganbbojjak.common.error.ErrorProperty

enum class GlobalErrorCode(
    override val status: Int,
    override val message: String,
) : ErrorProperty {

    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
}