package com.kodomo.juganbbojjak.domain.work_report.persistence

import com.kodomo.juganbbojjak.domain.work_report.model.WorkDetail
import com.kodomo.juganbbojjak.domain.work_report.persistence.entity.QWorkDetailEntity.workDetailEntity
import com.kodomo.juganbbojjak.domain.work_report.persistence.entity.QWorkReportEntity.workReportEntity
import com.kodomo.juganbbojjak.domain.work_report.persistence.mapper.WorkDetailMapper
import com.kodomo.juganbbojjak.domain.work_report.persistence.repository.WorkDetailRepository
import com.kodomo.juganbbojjak.domain.work_report.spi.WorkDetailPort
import com.kodomo.juganbbojjak.global.annotation.Adapter
import com.querydsl.jpa.impl.JPAQueryFactory
import java.util.*

@Adapter
class WorkDetailPersistenceAdapter(
    private val workDetailRepository: WorkDetailRepository,
    private val workDetailMapper: WorkDetailMapper,
    private val queryFactory: JPAQueryFactory
) : WorkDetailPort {

    override fun saveAllWorkDetails(workDetails: List<WorkDetail>) {
        workDetailRepository.saveAll(
            workDetails.map { workDetailMapper.toEntity(it) }
        )
    }

    override fun queryWorkDetailByWorkReportId(workReportId: UUID): List<WorkDetail> {
        return queryFactory
            .selectFrom(workDetailEntity)
            .join(workReportEntity)
            .on(workDetailEntity.workReportEntity.id.eq(workReportEntity.id))
            .where(workDetailEntity.workReportEntity.id.eq(workReportId))
            .fetch()
            .map { workDetailMapper.toDomain(it) }
    }
}