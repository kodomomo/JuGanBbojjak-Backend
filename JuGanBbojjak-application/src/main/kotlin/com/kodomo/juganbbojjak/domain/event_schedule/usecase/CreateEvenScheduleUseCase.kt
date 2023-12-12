package com.kodomo.juganbbojjak.domain.event_schedule.usecase

import com.kodomo.juganbbojjak.common.annotation.UseCase
import com.kodomo.juganbbojjak.common.spi.SecurityPort
import com.kodomo.juganbbojjak.domain.event_schedule.dto.request.CreateEvenScheduleRequest
import com.kodomo.juganbbojjak.domain.event_schedule.exception.WeeklyEventScheduleNotFoundException
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

        commandEventSchedulePort.saveAllEventSchedule(
            request.eventSchedule.stream()
                .map {
                    EventSchedule(
                        weeklyEventScheduleId = weeklyEventSchedule.id,
                        date = it.date,
                        name = it.name,
                        place = it.place,
                        headcount = it.headcount,
                        userId = userId,
                    )
                }.toList()
        )
    }
}