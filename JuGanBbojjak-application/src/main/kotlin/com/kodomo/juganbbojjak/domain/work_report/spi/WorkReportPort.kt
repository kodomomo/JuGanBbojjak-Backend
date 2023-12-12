package com.kodomo.juganbbojjak.domain.work_report.spi

import com.kodomo.juganbbojjak.domain.work_report.model.WorkReport
import java.util.UUID

interface WorkReportPort : CommandWorkReport, QueryWorkReport

interface CommandWorkReport {
    fun saveWorkReport(workReport: WorkReport): WorkReport
}

interface QueryWorkReport {
    fun queryWorkReportByWeeklyWorkReportId(weeklyWorkReportId: UUID, userId: UUID?): WorkReport?
}