package com.kodomo.juganbbojjak.domain.user.exception

import com.kodomo.juganbbojjak.common.error.JuGanBbojjakException
import com.kodomo.juganbbojjak.domain.user.exception.error.UserErrorCode

object UserNotFoundException : JuGanBbojjakException(
    UserErrorCode.USER_NOT_FOUND
)