package com.kodomo.juganbbojjak.domain.work_report.spi

import com.kodomo.juganbbojjak.domain.work_report.model.WeeklyWorkReport
import java.util.UUID

interface WeeklyWorkReportPort : CommandWeeklyWorkReportPort, QueryWeeklyWorkReportPort

interface CommandWeeklyWorkReportPort {

}

interface QueryWeeklyWorkReportPort {
    fun queryWeeklyWorkReportById(weeklyWorkReportId: UUID): WeeklyWorkReport
}