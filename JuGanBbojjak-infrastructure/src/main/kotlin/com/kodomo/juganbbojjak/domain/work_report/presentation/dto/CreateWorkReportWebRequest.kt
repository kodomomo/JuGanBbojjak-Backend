package com.kodomo.juganbbojjak.domain.work_report.presentation.dto

import com.kodomo.juganbbojjak.domain.work_report.dto.request.CreateWorkReportRequest
import com.kodomo.juganbbojjak.domain.work_report.dto.request.WorkReportDetails
import com.kodomo.juganbbojjak.domain.work_report.dto.request.WorkReportList
import com.kodomo.juganbbojjak.domain.work_report.model.WorkDetailType
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class CreateWorkReportWebRequest(

    val workReportList: List<@NotNull WorkReportListWebRequest>
) {
    fun toDomainRequest() = CreateWorkReportRequest(
        workReportList = workReportList.map {
            WorkReportList(
                title = it.title,
                workReportDetails = it.workReportDetails.map { detail ->
                    WorkReportDetails(
                        contentKey = detail.contentKey,
                        contentValue = detail.contentValue,
                        contentType = detail.contentType
                    )
                }
            )
        }
    )
}

data class WorkReportListWebRequest(

    @field:NotBlank
    val title: String,

    val workReportDetails: List<@NotNull WorkReportDetailsWebRequest>
)

data class WorkReportDetailsWebRequest(
    @field:NotBlank
    val contentKey: String,

    @field:NotBlank
    val contentValue: String,

    @field:NotBlank
    val contentType: WorkDetailType
)