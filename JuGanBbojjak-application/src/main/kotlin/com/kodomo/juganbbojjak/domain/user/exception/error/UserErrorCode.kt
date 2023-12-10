package com.kodomo.juganbbojjak.domain.user.exception.error

import com.kodomo.juganbbojjak.common.error.ErrorProperty

enum class UserErrorCode(
    override val status: Int,
    override val message: String,
) : ErrorProperty {

    TEAM_NOT_FOUND(404, "Team Not Found"),
    USER_NOT_FOUND(404, "User Not Found")
}