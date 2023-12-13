package com.kodomo.juganbbojjak.domain.work_report.persistence.vo

import com.kodomo.juganbbojjak.domain.work_report.model.WorkDetail
import com.kodomo.juganbbojjak.domain.work_report.persistence.entity.WorkDetailEntity
import com.kodomo.juganbbojjak.domain.work_report.spi.vo.WorkReportDetailsVO
import com.querydsl.core.annotations.QueryProjection
import java.util.*

class QueryWorkReportDetailsVO @QueryProjection constructor(
    workReportId: UUID,
    title: String,
    workDetailsList: List<WorkDetailEntity>
) : WorkReportDetailsVO(
    workReportId = workReportId,
    title = title,
    workDetailsList = workDetailsList.map {
        WorkDetail(
            id = it.id,
            title = it.title,
            content = it.content,
            type = it.type,
            workReportId = it.workReportEntity.id
        )
    }
)
