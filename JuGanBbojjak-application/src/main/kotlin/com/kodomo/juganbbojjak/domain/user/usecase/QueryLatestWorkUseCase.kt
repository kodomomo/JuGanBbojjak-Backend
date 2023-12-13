package com.kodomo.juganbbojjak.domain.user.usecase

import com.kodomo.juganbbojjak.common.annotation.UseCase
import com.kodomo.juganbbojjak.domain.event_schedule.exception.WeeklyEventScheduleNotFoundException
import com.kodomo.juganbbojjak.domain.event_schedule.spi.QueryEventSchedulePort
import com.kodomo.juganbbojjak.domain.user.dto.response.QueryLatestWorkResponse
import com.kodomo.juganbbojjak.domain.work_report.spi.QueryWeeklyWorkReportPort

@UseCase
class QueryLatestWorkUseCase(
    private val queryWeeklyWorkReportPort: QueryWeeklyWorkReportPort,
    private val queryEventSchedulePort: QueryEventSchedulePort
) {

    fun execute(): QueryLatestWorkResponse {
        val weeklyWorkReport = queryWeeklyWorkReportPort.queryLatestWeeklyWorkReport()
        val eventSchedule = queryEventSchedulePort.queryLatestEventSchedule()
            ?: throw WeeklyEventScheduleNotFoundException

        return QueryLatestWorkResponse(
            workReportId = weeklyWorkReport.id,
            workReportStartDate = weeklyWorkReport.startDate,
            workReportEndDate = weeklyWorkReport.endDate,
            eventScheduleId = eventSchedule.id,
            eventScheduleStartDate = eventSchedule.startDate,
            eventScheduleEndDate = eventSchedule.endDate
        )
    }
}