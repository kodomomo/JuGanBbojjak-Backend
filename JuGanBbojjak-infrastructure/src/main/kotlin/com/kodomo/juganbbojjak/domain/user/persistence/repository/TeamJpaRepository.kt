package com.kodomo.juganbbojjak.domain.user.persistence.repository

import com.kodomo.juganbbojjak.domain.user.persistence.entity.TeamEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface TeamJpaRepository : JpaRepository<TeamEntity, UUID> {
}