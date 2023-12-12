package com.kodomo.juganbbojjak.domain.work_report.dto.reponse

import com.kodomo.juganbbojjak.domain.work_report.model.WorkDetailType

data class QueryWorkReportDetailsResponse(
    val title: String,
    val workReportList: List<WorkReportListResponse>
)

data class WorkReportListResponse(
    val contentKey: String,
    val contentValue: String,
    val contentType: WorkDetailType
)