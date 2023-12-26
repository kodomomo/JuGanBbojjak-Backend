package com.kodomo.juganbbojjak.domain.work_report.spi

import com.kodomo.juganbbojjak.domain.work_report.model.WeeklyWorkReport
import java.util.UUID

interface WeeklyWorkReportPort : CommandWeeklyWorkReportPort, QueryWeeklyWorkReportPort

interface CommandWeeklyWorkReportPort {
    fun saveWeeklyWorkReport(weeklyWorkReport: WeeklyWorkReport)
}

interface QueryWeeklyWorkReportPort {
    fun queryWeeklyWorkReportById(weeklyWorkReportId: UUID): WeeklyWorkReport
    fun queryAllWeeklyWorkReportList(): List<WeeklyWorkReport>
    fun queryLatestWeeklyWorkReport(): WeeklyWorkReport
}