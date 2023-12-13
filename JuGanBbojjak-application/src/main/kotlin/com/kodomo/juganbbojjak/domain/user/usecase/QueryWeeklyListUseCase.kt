package com.kodomo.juganbbojjak.domain.user.usecase

import com.kodomo.juganbbojjak.common.annotation.UseCase
import com.kodomo.juganbbojjak.domain.event_schedule.spi.QueryEventSchedulePort
import com.kodomo.juganbbojjak.domain.user.dto.response.QueryWeeklyListResponse
import com.kodomo.juganbbojjak.domain.user.dto.response.WeeklyList
import com.kodomo.juganbbojjak.domain.user.model.WeeklyListType
import com.kodomo.juganbbojjak.domain.user.model.WeeklyListType.EVENT_SCHEDULE
import com.kodomo.juganbbojjak.domain.user.model.WeeklyListType.WORK_REPORT
import com.kodomo.juganbbojjak.domain.work_report.spi.QueryWeeklyWorkReportPort

@UseCase
class QueryWeeklyListUseCase(
    private val queryWeeklyWorkReportPort: QueryWeeklyWorkReportPort,
    private val queryWeeklySchedulePort: QueryEventSchedulePort
) {

    fun execute(weeklyListType: WeeklyListType): QueryWeeklyListResponse =

        when (weeklyListType) {
            WORK_REPORT -> QueryWeeklyListResponse(
                queryWeeklyWorkReportPort.queryAllWeeklyWorkReportList().map {
                    WeeklyList(
                        id = it.id,
                        startDate = it.startDate,
                        endDate = it.endDate,
                        type = WORK_REPORT
                    )
                }
            )

            EVENT_SCHEDULE -> QueryWeeklyListResponse(
                queryWeeklySchedulePort.queryAllEventScheduleList().map {
                    WeeklyList(
                        id = it.id,
                        startDate = it.startDate,
                        endDate = it.endDate,
                        type = EVENT_SCHEDULE
                    )
                }
            )
        }
}