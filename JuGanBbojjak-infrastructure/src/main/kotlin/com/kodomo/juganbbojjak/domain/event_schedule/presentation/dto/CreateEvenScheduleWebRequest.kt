package com.kodomo.juganbbojjak.domain.event_schedule.presentation.dto

import com.kodomo.juganbbojjak.domain.event_schedule.dto.request.CreateEvenScheduleRequest
import com.kodomo.juganbbojjak.domain.event_schedule.dto.request.EventDetailRequest
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.LocalDate

data class CreateEvenScheduleWebRequest(
    val eventSchedule: List<@NotNull EventDetailWebRequest>
) {
    fun toDomainRequest() = CreateEvenScheduleRequest(
        eventSchedule.stream()
            .map {
                EventDetailRequest(
                    date = it.date,
                    name = it.name,
                    place = it.place,
                    headcount = it.headcount,
                )
            }.toList()
    )
}

data class EventDetailWebRequest(

    @field:NotNull
    val date: LocalDate,

    @field:NotBlank
    val name: String,

    @field:NotBlank
    val place: String,

    @field:NotNull
    val headcount: Int,
)