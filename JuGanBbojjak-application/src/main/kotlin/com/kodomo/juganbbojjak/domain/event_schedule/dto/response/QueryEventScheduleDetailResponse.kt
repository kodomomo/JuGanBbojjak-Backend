package com.kodomo.juganbbojjak.domain.event_schedule.dto.response

import com.kodomo.juganbbojjak.domain.event_schedule.model.EventSchedule
import java.time.LocalDate

data class QueryEventScheduleDetailResponse(
    val startDate: LocalDate,
    val endDate: LocalDate,
    val eventSchedules: List<EventDetailResponse>,
)

data class EventDetailResponse(
    val date: LocalDate,
    val name: String,
    val place: String,
    val headcount: Int,
)