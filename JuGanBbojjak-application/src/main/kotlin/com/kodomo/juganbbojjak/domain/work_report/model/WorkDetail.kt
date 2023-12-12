package com.kodomo.juganbbojjak.domain.work_report.model

import com.kodomo.juganbbojjak.common.annotation.Aggregate
import java.util.UUID

@Aggregate
class WorkDetail(

    val id: UUID = UUID.randomUUID(),

    val title: String,

    val content: String,

    val type: WorkDetailType,

    val workReportId: UUID
)