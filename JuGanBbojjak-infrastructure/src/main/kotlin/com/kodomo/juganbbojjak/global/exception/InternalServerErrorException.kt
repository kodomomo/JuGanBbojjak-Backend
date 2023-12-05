package com.kodomo.juganbbojjak.global.exception

import com.kodomo.juganbbojjak.common.error.JuGanBbojjakException
import com.kodomo.juganbbojjak.global.error.GlobalErrorCode

object InternalServerErrorException : JuGanBbojjakException(
    GlobalErrorCode.INTERNAL_SERVER_ERROR
)