package com.kodomo.juganbbojjak.domain.event_schedule.persistence.repository

import com.kodomo.juganbbojjak.domain.event_schedule.persistence.entity.EventScheduleEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface EventScheduleJpaRepository : JpaRepository<EventScheduleEntity, UUID> {
}