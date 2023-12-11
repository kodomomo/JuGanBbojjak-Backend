package com.kodomo.juganbbojjak.domain.event_schedule.model

import com.kodomo.juganbbojjak.common.annotation.Aggregate
import java.time.LocalDate
import java.util.UUID

@Aggregate
data class WeeklyEventSchedule(
   val id: UUID,
    val startDate: LocalDate,
    val endDate: LocalDate,
)