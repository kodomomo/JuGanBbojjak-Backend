package com.kodomo.juganbbojjak.domain.work_report.model

import com.kodomo.juganbbojjak.common.annotation.Aggregate
import com.kodomo.juganbbojjak.domain.work_report.dto.request.UpdateWorkReportDetailsRequest
import java.util.UUID

@Aggregate
data class WorkDetail(

    val id: UUID = UUID.randomUUID(),

    val title: String,

    val content: String,

    val type: WorkDetailType,

    val workReportId: UUID
) {

    fun updateWorkDetail(updateWorkReportDetails: UpdateWorkReportDetailsRequest): WorkDetail =
        WorkDetail(
            id = id,
            title = updateWorkReportDetails.contentKey,
            content = updateWorkReportDetails.contentValue,
            workReportId = workReportId,
            type = type
        )
}