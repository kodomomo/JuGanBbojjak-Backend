package com.kodomo.juganbbojjak.domain.work_report.model

import com.kodomo.juganbbojjak.common.annotation.Aggregate
import java.time.LocalDate
import java.util.UUID

@Aggregate
class WeeklyWorkReport(

    val id: UUID = UUID.randomUUID(),

    val startDate: LocalDate,

    val endDate: LocalDate
)