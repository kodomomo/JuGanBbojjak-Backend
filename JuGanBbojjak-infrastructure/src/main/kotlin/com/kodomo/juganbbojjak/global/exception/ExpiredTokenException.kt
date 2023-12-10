package com.kodomo.juganbbojjak.global.exception

import com.kodomo.juganbbojjak.common.error.JuGanBbojjakException
import com.kodomo.juganbbojjak.global.error.GlobalErrorCode

object ExpiredTokenException : JuGanBbojjakException(
    GlobalErrorCode.EXPIRED_TOKEN,
)
