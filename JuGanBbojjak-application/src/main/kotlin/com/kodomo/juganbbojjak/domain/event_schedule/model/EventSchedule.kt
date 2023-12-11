package com.kodomo.juganbbojjak.domain.event_schedule.model

import com.kodomo.juganbbojjak.common.annotation.Aggregate
import java.util.UUID

@Aggregate
data class EventSchedule(
    val id: UUID = UUID.randomUUID(),
    val weeklyEventScheduleId: UUID,
    val userId: UUID,
)