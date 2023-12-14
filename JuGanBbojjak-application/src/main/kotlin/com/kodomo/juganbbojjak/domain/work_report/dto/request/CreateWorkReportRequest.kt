package com.kodomo.juganbbojjak.domain.work_report.dto.request

import com.kodomo.juganbbojjak.domain.work_report.model.WorkDetailType

data class CreateWorkReportRequest(
    val workReportList: List<WorkReportList>
)

data class WorkReportList(
    val title: String,
    val workReportDetails: List<WorkReportDetails>
)

data class WorkReportDetails(
    val contentKey: String,
    val contentValue: String,
    val contentType: WorkDetailType
)