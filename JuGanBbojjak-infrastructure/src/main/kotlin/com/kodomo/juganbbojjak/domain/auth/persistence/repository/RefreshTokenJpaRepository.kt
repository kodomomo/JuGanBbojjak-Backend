package com.kodomo.juganbbojjak.domain.auth.persistence.repository

import com.kodomo.juganbbojjak.domain.auth.persistence.entity.RefreshTokenEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface RefreshTokenJpaRepository : JpaRepository<RefreshTokenEntity, UUID> {
}