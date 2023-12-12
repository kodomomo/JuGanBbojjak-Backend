package com.kodomo.juganbbojjak.global.security

import com.kodomo.juganbbojjak.common.spi.SecurityPort
import com.kodomo.juganbbojjak.domain.user.model.Authority
import com.kodomo.juganbbojjak.global.annotation.Adapter
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import java.util.UUID

@Adapter
class SecurityAdapter(
    private val passwordEncoder: PasswordEncoder,
) : SecurityPort {

    override fun encodePassword(password: String): String =
        passwordEncoder.encode(password)

    override fun getCurrentUserId(): UUID = UUID.fromString(
        SecurityContextHolder.getContext().authentication.name,
    )

    override fun matchPassword(rawPassword: String, encodePassword: String): Boolean =
        passwordEncoder.matches(rawPassword, encodePassword)
}