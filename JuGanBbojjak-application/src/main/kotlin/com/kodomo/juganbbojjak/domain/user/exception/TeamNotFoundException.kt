package com.kodomo.juganbbojjak.domain.user.exception

import com.kodomo.juganbbojjak.common.error.JuGanBbojjakException
import com.kodomo.juganbbojjak.domain.user.exception.error.UserErrorCode

object TeamNotFoundException : JuGanBbojjakException(
    UserErrorCode.TEAM_NOT_FOUND
)