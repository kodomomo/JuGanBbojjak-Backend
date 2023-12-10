package com.kodomo.juganbbojjak.domain.auth.persistence.repository

import com.kodomo.juganbbojjak.domain.auth.persistence.entity.RefreshTokenEntity
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface RefreshTokenJpaRepository : CrudRepository<RefreshTokenEntity, UUID> {
}