package com.kodomo.juganbbojjak.domain.work_report.presentation.dto

import com.kodomo.juganbbojjak.domain.work_report.dto.request.UpdateWorkReportDetailsRequest
import com.kodomo.juganbbojjak.domain.work_report.dto.request.UpdateWorkReportRequest
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.util.*

data class UpdateWorkReportWebRequest(

    @NotBlank
    val workReportId: UUID,

    @NotBlank
    val title: String,

    val workReportDetails: List<@NotNull UpdateWorkReportDetailsWebRequest>
) {
    fun toDomainRequest() = UpdateWorkReportRequest(
        workReportId = workReportId,
        title = title,
        workReportDetails = workReportDetails.map {
            UpdateWorkReportDetailsRequest(
                workDetailId = it.workDetailId,
                contentKey = it.contentKey,
                contentValue = it.contentValue
            )
        }
    )
}

data class UpdateWorkReportDetailsWebRequest(

    @NotBlank
    val workDetailId: UUID,

    @NotBlank
    val contentKey: String,

    @NotBlank
    val contentValue: String
)