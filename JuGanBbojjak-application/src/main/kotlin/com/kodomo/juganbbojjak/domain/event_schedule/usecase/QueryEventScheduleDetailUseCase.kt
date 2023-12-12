package com.kodomo.juganbbojjak.domain.event_schedule.usecase

import com.kodomo.juganbbojjak.common.annotation.UseCase
import com.kodomo.juganbbojjak.common.spi.SecurityPort
import com.kodomo.juganbbojjak.domain.event_schedule.dto.response.EventDetailResponse
import com.kodomo.juganbbojjak.domain.event_schedule.dto.response.QueryEventScheduleDetailResponse
import com.kodomo.juganbbojjak.domain.event_schedule.exception.WeeklyEventScheduleNotFoundException
import com.kodomo.juganbbojjak.domain.event_schedule.spi.QueryEventSchedulePort
import com.kodomo.juganbbojjak.domain.user.exception.UserNotFoundException
import com.kodomo.juganbbojjak.domain.user.model.Authority
import com.kodomo.juganbbojjak.domain.user.spi.QueryUserPort
import java.util.UUID

@UseCase
class QueryEventScheduleDetailUseCase(
    private val queryEventSchedulePort: QueryEventSchedulePort,
    private val queryUserPort: QueryUserPort,
    private val securityPort: SecurityPort,
) {

    fun execute(weeklyEventScheduleId: UUID): QueryEventScheduleDetailResponse {
        val user = queryUserPort.queryUserById(securityPort.getCurrentUserId()) ?: throw UserNotFoundException
        val weeklyEventSchedule = queryEventSchedulePort.queryWeeklyEventScheduleById(weeklyEventScheduleId)
            ?: throw WeeklyEventScheduleNotFoundException
        val eventSchedules = when (user.authority) {
            Authority.USER -> queryEventSchedulePort.queryEventSchedulesByWeeklyEventScheduleId(
                weeklyEventScheduleId,
                user.id,
            )

            Authority.ADMIN -> queryEventSchedulePort.queryEventSchedulesByWeeklyEventScheduleId(
                weeklyEventScheduleId,
                null,
            )
        }

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