package com.kodomo.juganbbojjak.domain.event_schedule.presentation.dto

import com.kodomo.juganbbojjak.domain.event_schedule.dto.CreateWeeklyEventScheduleRequest
import org.jetbrains.annotations.NotNull
import java.time.LocalDate

data class CreateWeeklyEventScheduleWebRequest(

    @field:NotNull
    val startDate: LocalDate,

    @field:NotNull
    val endDate: LocalDate,
) {

    fun toDomainRequest() = CreateWeeklyEventScheduleRequest(
        startDate = startDate,
        endDate = endDate,
    )
}
