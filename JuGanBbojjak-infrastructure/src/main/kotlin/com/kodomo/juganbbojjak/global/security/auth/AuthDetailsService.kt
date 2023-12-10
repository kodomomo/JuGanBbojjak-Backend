package com.kodomo.juganbbojjak.global.security.auth

import com.kodomo.juganbbojjak.domain.user.exception.UserNotFoundException
import com.kodomo.juganbbojjak.domain.user.persistence.UserPersistenceAdapter
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class AuthDetailsService(
    private val userPersistenceAdapter: UserPersistenceAdapter,
) : UserDetailsService {

    override fun loadUserByUsername(userId: String) = userPersistenceAdapter.queryUserById(
        UUID.fromString(userId)
    )?.let {
        AuthDetails(it)
    } ?: throw UserNotFoundException
}