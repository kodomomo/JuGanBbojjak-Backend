package com.kodomo.juganbbojjak.domain.event_schedule.usecase

import com.kodomo.juganbbojjak.common.annotation.UseCase
import com.kodomo.juganbbojjak.common.spi.SecurityPort
import com.kodomo.juganbbojjak.domain.event_schedule.dto.request.CreateEvenScheduleRequest
import com.kodomo.juganbbojjak.domain.event_schedule.exception.WeeklyEventScheduleNotFoundException
import com.kodomo.juganbbojjak.domain.event_schedule.model.EventDetail
import com.kodomo.juganbbojjak.domain.event_schedule.model.EventSchedule
import com.kodomo.juganbbojjak.domain.event_schedule.spi.CommandEventSchedulePort
import com.kodomo.juganbbojjak.domain.event_schedule.spi.QueryEventSchedulePort
import java.util.UUID

@UseCase
class CreateEvenScheduleUseCase(
    private val securityPort: SecurityPort,
    private val queryEventSchedulePort: QueryEventSchedulePort,
    private val commandEventSchedulePort: CommandEventSchedulePort,
) {

    fun execute(weeklyEventScheduleId: UUID, request: CreateEvenScheduleRequest) {
        val userId = securityPort.getCurrentUserId()
        val weeklyEventSchedule = queryEventSchedulePort.queryWeeklyEventScheduleById(weeklyEventScheduleId)
            ?: throw WeeklyEventScheduleNotFoundException

        val eventSchedule = commandEventSchedulePort.saveEventSchedule(
            EventSchedule(
                weeklyEventScheduleId = weeklyEventSchedule.id,
                userId = userId,
            )
        )

        commandEventSchedulePort.saveAllEventDetail(
            request.eventSchedule.stream()
                .map {
                    EventDetail(
                        date = it.date,
                        name = it.name,
                        place = it.place,
                        headcount = it.headcount,
                        eventScheduleId = eventSchedule.id
                    )
                }.toList()
        )
    }
}