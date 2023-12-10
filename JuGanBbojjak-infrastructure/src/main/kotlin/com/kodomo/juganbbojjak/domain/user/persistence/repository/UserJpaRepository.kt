package com.kodomo.juganbbojjak.domain.user.persistence.repository

import com.kodomo.juganbbojjak.domain.user.persistence.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserJpaRepository : JpaRepository<UserEntity, UUID> {
    fun findByAccountId(accountId: String): UserEntity?
}