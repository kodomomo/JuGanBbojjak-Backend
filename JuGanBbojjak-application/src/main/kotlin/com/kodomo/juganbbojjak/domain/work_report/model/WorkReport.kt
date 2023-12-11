package com.kodomo.juganbbojjak.domain.work_report.model

import com.kodomo.juganbbojjak.common.annotation.Aggregate
import java.util.UUID

@Aggregate
class WorkReport (

    val id: UUID = UUID.randomUUID(),

    val title: String,

    val weeklyWorkReportId: UUID,

    val userId: UUID
)