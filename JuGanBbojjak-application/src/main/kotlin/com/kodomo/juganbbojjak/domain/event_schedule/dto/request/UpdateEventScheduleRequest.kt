package com.kodomo.juganbbojjak.domain.event_schedule.dto.request

import java.time.LocalDate

data class UpdateEventScheduleRequest(
    val date: LocalDate,
    val name: String,
    val place: String,
    val headcount: Int,
)