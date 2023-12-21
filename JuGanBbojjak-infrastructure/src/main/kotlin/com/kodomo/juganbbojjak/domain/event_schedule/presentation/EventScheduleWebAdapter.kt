package com.kodomo.juganbbojjak.domain.event_schedule.presentation

import com.kodomo.juganbbojjak.domain.event_schedule.dto.response.QueryEventScheduleDetailResponse
import com.kodomo.juganbbojjak.domain.event_schedule.presentation.dto.CreateEvenScheduleWebRequest
import com.kodomo.juganbbojjak.domain.event_schedule.presentation.dto.CreateWeeklyEventScheduleWebRequest
import com.kodomo.juganbbojjak.domain.event_schedule.presentation.dto.UpdateEventScheduleWebRequest
import com.kodomo.juganbbojjak.domain.event_schedule.usecase.CreateEvenScheduleUseCase
import com.kodomo.juganbbojjak.domain.event_schedule.usecase.CreateWeeklyEventScheduleUseCase
import com.kodomo.juganbbojjak.domain.event_schedule.usecase.QueryEventScheduleDetailUseCase
import com.kodomo.juganbbojjak.domain.event_schedule.usecase.UpdateEventScheduleUseCase
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RequestMapping("/event_schedules")
@RestController
class EventScheduleWebAdapter(
    private val createEvenScheduleUseCase: CreateEvenScheduleUseCase,
    private val queryEventScheduleDetailUseCase: QueryEventScheduleDetailUseCase,
    private val updateEventScheduleUseCase: UpdateEventScheduleUseCase,
    private val createWeeklyEventScheduleUseCase: CreateWeeklyEventScheduleUseCase,
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{weekly-event-schedule-id}")
    fun createEventSchedule(
        @PathVariable("weekly-event-schedule-id") weeklyEventScheduleId: UUID,
        @RequestBody @Valid request: CreateEvenScheduleWebRequest
    ) {
        createEvenScheduleUseCase.execute(weeklyEventScheduleId, request.toDomainRequest())
    }

    @GetMapping("/{weekly-event-schedule-id}")
    fun queryEventSchedules(
        @PathVariable("weekly-event-schedule-id") weeklyEventScheduleId: UUID
    ): QueryEventScheduleDetailResponse = queryEventScheduleDetailUseCase.execute(weeklyEventScheduleId)

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{event-schedule-id}")
    fun updateEventSchedule(
        @PathVariable("event-schedule-id") eventScheduleId: UUID,
        @RequestBody @Valid request: UpdateEventScheduleWebRequest,
    ) {
        updateEventScheduleUseCase.execute(eventScheduleId, request.toDomainRequest())
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createWeeklyEventSchedule(
        @RequestBody @Valid request: CreateWeeklyEventScheduleWebRequest,
    ) {
        createWeeklyEventScheduleUseCase.execute(request.toDomainRequest())
    }
}