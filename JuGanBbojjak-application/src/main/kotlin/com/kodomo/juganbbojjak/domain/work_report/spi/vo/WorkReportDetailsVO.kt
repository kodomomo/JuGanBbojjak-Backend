package com.kodomo.juganbbojjak.domain.work_report.spi.vo

import com.kodomo.juganbbojjak.domain.work_report.model.WorkDetail
import java.util.*

open class WorkReportDetailsVO (
    val workReportId: UUID,
    val title: String,
    val workDetailsList: List<WorkDetail>
)