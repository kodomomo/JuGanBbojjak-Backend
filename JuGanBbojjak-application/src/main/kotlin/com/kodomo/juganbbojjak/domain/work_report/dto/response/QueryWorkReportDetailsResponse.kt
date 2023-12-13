package com.kodomo.juganbbojjak.domain.work_report.dto.response

import com.kodomo.juganbbojjak.domain.work_report.model.WorkDetailType
import java.util.UUID

data class QueryWorkReportDetailsResponse(
    val workReportList: List<WorkReportListResponse>
)

data class WorkReportListResponse(
    val workReportId: UUID,
    val title: String,
    val workReportDetails: List<WorkReportDetailsResponse>
)
data class WorkReportDetailsResponse(
    val workDetailId: UUID,
    val contentKey: String,
    val contentValue: String,
    val contentType: WorkDetailType
)
