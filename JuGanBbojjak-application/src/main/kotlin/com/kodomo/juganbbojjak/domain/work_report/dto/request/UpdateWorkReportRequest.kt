package com.kodomo.juganbbojjak.domain.work_report.dto.request

import java.util.UUID

data class UpdateWorkReportRequest(
    val workReportId: UUID,
    val title: String,
    val workReportDetails: List<UpdateWorkReportDetailsRequest>
)

data class UpdateWorkReportDetailsRequest(
    val workDetailId: UUID,
    val contentKey: String,
    val contentValue: String
)