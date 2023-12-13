package com.kodomo.juganbbojjak.domain.event_schedule.presentation.dto

import com.kodomo.juganbbojjak.domain.event_schedule.dto.request.UpdateEventScheduleRequest
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.time.LocalDate

data class UpdateEventScheduleWebRequest(

    @field:NotNull
    val date: LocalDate,

    @field:NotBlank
    val name: String,

    @field:NotBlank
    val place: String,

    @field:NotNull
    val headcount: Int,
) {

    fun toDomainRequest() = UpdateEventScheduleRequest(
        date = date,
        name = name,
        place = place,
        headcount = headcount,
    )
}
