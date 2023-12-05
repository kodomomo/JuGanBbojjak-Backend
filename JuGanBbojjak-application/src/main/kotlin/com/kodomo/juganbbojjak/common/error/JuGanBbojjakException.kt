package com.kodomo.juganbbojjak.common.error

import java.lang.RuntimeException

abstract class JuGanBbojjakException(
    val errorProperty: ErrorProperty
) : RuntimeException()