package com.kodomo.juganbbojjak.domain.event_schedule.model

import com.kodomo.juganbbojjak.common.annotation.Aggregate
import java.time.LocalDate
import java.util.UUID

@Aggregate
data class EventSchedule(
    val id: UUID = UUID.randomUUID(),
    val date: LocalDate,
    val name: String,
    val place: String,
    val headcount: Int,
    val weeklyEventScheduleId: UUID,
    val userId: UUID,
)