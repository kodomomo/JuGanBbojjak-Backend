package com.kodomo.juganbbojjak.domain.user.dto.response

import java.time.LocalDate
import java.util.UUID

data class QueryLatestWorkResponse(
    val workReportId: UUID,
    val workReportStartDate: LocalDate,
    val workReportEndDate: LocalDate,
    val eventScheduleId: UUID,
    val eventScheduleStartDate: LocalDate,
    val eventScheduleEndDate: LocalDate
)