package com.kodomo.juganbbojjak.domain.work_report.persistence.mapper

import com.kodomo.juganbbojjak.domain.work_report.model.WeeklyWorkReport
import com.kodomo.juganbbojjak.domain.work_report.persistence.entity.WeeklyWorkReportEntity
import org.springframework.stereotype.Component

@Component
class WeeklyWorkReportMapper {

    fun toDomain(entity: WeeklyWorkReportEntity): WeeklyWorkReport =
        entity.run {
            WeeklyWorkReport(
                id = id,
                startDate = startDate,
                endDate = endDate
            )
        }


    fun toEntity(domain: WeeklyWorkReport): WeeklyWorkReportEntity =
        domain.run {
            WeeklyWorkReportEntity(
                id = id,
                startDate = startDate,
                endDate = endDate
            )
        }

}