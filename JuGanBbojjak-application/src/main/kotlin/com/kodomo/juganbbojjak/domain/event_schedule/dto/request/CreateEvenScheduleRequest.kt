package com.kodomo.juganbbojjak.domain.event_schedule.dto.request

import java.time.LocalDate

data class CreateEvenScheduleRequest(
    val eventSchedule: List<EventDetailRequest>
)

data class EventDetailRequest(
    val date: LocalDate,
    val name: String,
    val place: String,
    val headcount: Int,
)
