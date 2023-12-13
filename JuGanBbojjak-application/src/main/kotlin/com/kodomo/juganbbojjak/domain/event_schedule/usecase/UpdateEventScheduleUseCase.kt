package com.kodomo.juganbbojjak.domain.event_schedule.usecase

import com.kodomo.juganbbojjak.common.annotation.UseCase
import com.kodomo.juganbbojjak.domain.event_schedule.dto.request.UpdateEventScheduleRequest
import com.kodomo.juganbbojjak.domain.event_schedule.exception.EventScheduleNotFoundException
import com.kodomo.juganbbojjak.domain.event_schedule.spi.CommandEventSchedulePort
import com.kodomo.juganbbojjak.domain.event_schedule.spi.QueryEventSchedulePort
import java.util.UUID

@UseCase
class UpdateEventScheduleUseCase(
    private val queryEventSchedulePort: QueryEventSchedulePort,
    private val commandEventSchedulePort: CommandEventSchedulePort,
) {

    fun execute(eventScheduleId: UUID, request: UpdateEventScheduleRequest) {
        val eventSchedule = queryEventSchedulePort.queryEventScheduleById(eventScheduleId)
            ?: throw EventScheduleNotFoundException

        commandEventSchedulePort.saveEventSchedule(
            eventSchedule.update(
                date = request.date,
                name = request.name,
                place = request.place,
                headcount = request.headcount,
            )
        )
    }
}