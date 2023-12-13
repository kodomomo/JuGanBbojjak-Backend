package com.kodomo.juganbbojjak.domain.event_schedule.persistence.repository

import com.kodomo.juganbbojjak.domain.event_schedule.persistence.entity.WeeklyEventScheduleEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface WeeklyEventScheduleJpaRepository : JpaRepository<WeeklyEventScheduleEntity, UUID> {
    fun findAllByOrderByEndDateDesc(): List<WeeklyEventScheduleEntity>
    fun findTopByOrderByEndDateDesc(): WeeklyEventScheduleEntity?
}