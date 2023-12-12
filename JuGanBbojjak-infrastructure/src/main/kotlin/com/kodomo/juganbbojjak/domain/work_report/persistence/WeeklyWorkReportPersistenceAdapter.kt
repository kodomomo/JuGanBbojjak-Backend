package com.kodomo.juganbbojjak.domain.work_report.persistence

import com.kodomo.juganbbojjak.domain.work_report.exception.WeeklyWorkReportNotFoundException
import com.kodomo.juganbbojjak.domain.work_report.model.WeeklyWorkReport
import com.kodomo.juganbbojjak.domain.work_report.persistence.mapper.WeeklyWorkReportMapper
import com.kodomo.juganbbojjak.domain.work_report.persistence.repository.WeeklyWorkReportRepository
import com.kodomo.juganbbojjak.domain.work_report.spi.WeeklyWorkReportPort
import com.kodomo.juganbbojjak.global.annotation.Adapter
import org.springframework.data.repository.findByIdOrNull
import java.util.*

@Adapter
class WeeklyWorkReportPersistenceAdapter(
    private val weeklyWorkReportRepository: WeeklyWorkReportRepository,
    private val weeklyWorkReportMapper: WeeklyWorkReportMapper
) : WeeklyWorkReportPort {

    override fun queryWeeklyWorkReportById(weeklyWorkReportId: UUID): WeeklyWorkReport =
        weeklyWorkReportMapper.toDomain(
            weeklyWorkReportRepository.findByIdOrNull(weeklyWorkReportId)
                ?: throw WeeklyWorkReportNotFoundException
        )

}