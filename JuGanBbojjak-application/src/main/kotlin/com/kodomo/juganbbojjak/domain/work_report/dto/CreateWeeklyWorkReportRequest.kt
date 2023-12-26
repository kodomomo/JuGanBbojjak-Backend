package com.kodomo.juganbbojjak.domain.work_report.dto

import java.time.LocalDate

data class CreateWeeklyWorkReportRequest(
    val startDate: LocalDate,
    val endDate: LocalDate,
)
