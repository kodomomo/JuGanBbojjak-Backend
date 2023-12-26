package com.kodomo.juganbbojjak.domain.event_schedule.dto

import java.time.LocalDate

data class CreateWeeklyEventScheduleRequest(
    val startDate: LocalDate,
    val endDate: LocalDate,
)
