package com.kodomo.juganbbojjak.domain.event_schedule.usecase

import com.kodomo.juganbbojjak.common.annotation.UseCase
import com.kodomo.juganbbojjak.domain.event_schedule.dto.CreateWeeklyEventScheduleRequest
import com.kodomo.juganbbojjak.domain.event_schedule.model.WeeklyEventSchedule
import com.kodomo.juganbbojjak.domain.event_schedule.spi.CommandEventSchedulePort

@UseCase
class CreateWeeklyEventScheduleUseCase(
    private val commandEventSchedulePort: CommandEventSchedulePort,
) {

    fun execute(request: CreateWeeklyEventScheduleRequest) {
        commandEventSchedulePort.saveWeeklyEventSchedule(
            WeeklyEventSchedule(
                startDate = request.startDate,
                endDate = request.endDate,
            )
        )
    }
}