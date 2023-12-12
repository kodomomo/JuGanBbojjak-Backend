package com.kodomo.juganbbojjak.domain.event_schedule.presentation

import com.kodomo.juganbbojjak.domain.event_schedule.presentation.dto.CreateEvenScheduleWebRequest
import com.kodomo.juganbbojjak.domain.event_schedule.usecase.CreateEvenScheduleUseCase
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RequestMapping("/event_schedules")
@RestController
class EventScheduleWebAdapter(
    private val createEvenScheduleUseCase: CreateEvenScheduleUseCase,
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{weekly-event-schedule-id}")
    fun createEventSchedule(
        @PathVariable("weekly-event-schedule-id") weeklyEventScheduleId: UUID,
        @RequestBody @Valid request: CreateEvenScheduleWebRequest
    ) {
        createEvenScheduleUseCase.execute(weeklyEventScheduleId, request.toDomainRequest())
    }
}