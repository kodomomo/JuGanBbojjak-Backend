package com.kodomo.juganbbojjak.domain.work_report.dto.request

import com.kodomo.juganbbojjak.domain.work_report.model.WorkDetailType

data class CreateWorkReportRequest(
    val title: String,
    val workReportList: List<WorkReportList>
)

data class WorkReportList(
    val contentKey: String,
    val contentValue: String,
    val contentType: WorkDetailType
)