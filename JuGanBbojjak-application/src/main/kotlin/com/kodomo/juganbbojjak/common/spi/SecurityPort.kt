package com.kodomo.juganbbojjak.common.spi

import java.util.UUID

interface SecurityPort {
    fun encodePassword(password: String): String
    fun getCurrentUserId(): UUID
    fun matchPassword(rawPassword: String, encodePassword: String): Boolean
}