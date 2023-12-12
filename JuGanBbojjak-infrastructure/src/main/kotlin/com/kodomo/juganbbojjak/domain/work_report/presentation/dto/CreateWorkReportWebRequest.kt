package com.kodomo.juganbbojjak.domain.work_report.presentation.dto

import com.kodomo.juganbbojjak.domain.work_report.dto.request.CreateWorkReportRequest
import com.kodomo.juganbbojjak.domain.work_report.dto.request.WorkReportList
import com.kodomo.juganbbojjak.domain.work_report.model.WorkDetailType
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class CreateWorkReportWebRequest(

    @field:NotBlank
    val title: String,

    val workReportList: List<@NotNull WorkReportListWebRequest>
) {
    fun toDomainRequest() = CreateWorkReportRequest(
        title = title,
        workReportList = workReportList.map {
            WorkReportList(
                contentKey = it.contentKey,
                contentValue = it.contentValue,
                contentType = it.contentType
            )
        }
    )
}

data class WorkReportListWebRequest(

    @field:NotBlank
    val contentKey: String,

    @field:NotBlank
    val contentValue: String,

    @field:NotBlank
    val contentType: WorkDetailType
)