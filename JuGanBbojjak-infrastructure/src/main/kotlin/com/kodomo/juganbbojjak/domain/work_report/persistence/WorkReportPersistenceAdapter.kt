package com.kodomo.juganbbojjak.domain.work_report.persistence

import com.kodomo.juganbbojjak.domain.work_report.model.WorkReport
import com.kodomo.juganbbojjak.domain.work_report.persistence.entity.QWorkReportEntity.workReportEntity
import com.kodomo.juganbbojjak.domain.work_report.persistence.mapper.WorkReportMapper
import com.kodomo.juganbbojjak.domain.work_report.persistence.repository.WorkReportRepository
import com.kodomo.juganbbojjak.domain.work_report.persistence.vo.QQueryWorkReportDetailsVO
import com.kodomo.juganbbojjak.domain.work_report.spi.WorkReportPort
import com.kodomo.juganbbojjak.domain.work_report.spi.vo.WorkReportDetailsVO
import com.kodomo.juganbbojjak.global.annotation.Adapter
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import java.util.*
import kotlin.collections.List

@Adapter
class WorkReportPersistenceAdapter(
    private val workReportRepository: WorkReportRepository,
    private val workReportMapper: WorkReportMapper,
    private val queryFactory: JPAQueryFactory
) : WorkReportPort {

    override fun saveWorkReport(workReport: WorkReport): WorkReport =
        workReportMapper.toDomain(
            workReportRepository.save(
                workReportMapper.toEntity(workReport)
            )
        )

}