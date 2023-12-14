package com.kodomo.juganbbojjak.domain.work_report.persistence

import com.kodomo.juganbbojjak.domain.work_report.exception.WorkReportNotFoundException
import com.kodomo.juganbbojjak.domain.work_report.model.WorkReport
import com.kodomo.juganbbojjak.domain.work_report.persistence.mapper.WorkReportMapper
import com.kodomo.juganbbojjak.domain.work_report.persistence.repository.WorkReportRepository
import com.kodomo.juganbbojjak.domain.work_report.spi.WorkReportPort
import com.kodomo.juganbbojjak.global.annotation.Adapter
import org.springframework.data.repository.findByIdOrNull
import java.util.*

@Adapter
class WorkReportPersistenceAdapter(
    private val workReportRepository: WorkReportRepository,
    private val workReportMapper: WorkReportMapper,
) : WorkReportPort {

    override fun saveWorkReport(workReport: WorkReport): WorkReport =
        workReportMapper.toDomain(
            workReportRepository.save(
                workReportMapper.toEntity(workReport)
            )
        )

    override fun queryWorkReportById(workReportId: UUID): WorkReport =
        workReportMapper.toDomain(
            workReportRepository.findByIdOrNull(workReportId)
                ?: throw WorkReportNotFoundException
        )

}