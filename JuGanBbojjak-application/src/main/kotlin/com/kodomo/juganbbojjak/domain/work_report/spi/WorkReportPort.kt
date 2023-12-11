package com.kodomo.juganbbojjak.domain.work_report.spi

import com.kodomo.juganbbojjak.domain.work_report.model.WorkReport

interface WorkReportPort : CommandWorkReport

interface CommandWorkReport {
    fun saveWorkReport(workReport: WorkReport): WorkReport
}