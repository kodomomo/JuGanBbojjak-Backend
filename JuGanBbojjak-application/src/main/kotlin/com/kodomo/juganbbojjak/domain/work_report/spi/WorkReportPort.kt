package com.kodomo.juganbbojjak.domain.work_report.spi

import com.kodomo.juganbbojjak.domain.work_report.model.WeeklyWorkReport
import com.kodomo.juganbbojjak.domain.work_report.model.WorkReport
import java.util.UUID

interface WorkReportPort : CommandWorkReportPort, QueryWorkReportPort

interface CommandWorkReportPort {
    fun saveWorkReport(workReport: WorkReport): WorkReport
}

interface QueryWorkReportPort {
    fun queryWorkReportById(workReportId: UUID): WorkReport
}