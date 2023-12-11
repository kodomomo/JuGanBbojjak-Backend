package com.kodomo.juganbbojjak.domain.event_schedule.usecase

import com.kodomo.juganbbojjak.common.annotation.UseCase
import com.kodomo.juganbbojjak.domain.event_schedule.dto.response.EventDetailResponse
import com.kodomo.juganbbojjak.domain.event_schedule.dto.response.QueryEventScheduleDetailResponse
import com.kodomo.juganbbojjak.domain.event_schedule.exception.WeeklyEventScheduleNotFoundException
import com.kodomo.juganbbojjak.domain.event_schedule.spi.QueryEventSchedulePort
import java.util.UUID

@UseCase
class QueryEventScheduleDetailUseCase(
    private val queryEventSchedulePort: QueryEventSchedulePort,
) {

    fun execute(weeklyEventScheduleId: UUID): QueryEventScheduleDetailResponse {
        val weeklyEventSchedule = queryEventSchedulePort.queryWeeklyEventScheduleById(weeklyEventScheduleId)
            ?: throw WeeklyEventScheduleNotFoundException
        val eventSchedules = queryEventSchedulePort.queryEventSchedulesByWeeklyEventScheduleId(weeklyEventSchedule.id)

        return QueryEventScheduleDetailResponse(
            startDate = weeklyEventSchedule.startDate,
            endDate = weeklyEventSchedule.endDate,
            eventSchedules = eventSchedules.stream()
                .map {
                    EventDetailResponse(
                        date = it.date,
                        name = it.name,
                        place = it.place,
                        headcount = it.headcount,
                    )
                }.toList()
        )
    }
}