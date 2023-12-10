package com.kodomo.juganbbojjak.domain.auth.exception

import com.kodomo.juganbbojjak.common.error.JuGanBbojjakException
import com.kodomo.juganbbojjak.domain.auth.exception.error.AuthErrorCode

object InvalidPasswordException : JuGanBbojjakException(
    AuthErrorCode.INVALID_PASSWORD
)
