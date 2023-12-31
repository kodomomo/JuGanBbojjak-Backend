package com.kodomo.juganbbojjak.domain.work_report.persistence

import com.kodomo.juganbbojjak.domain.work_report.exception.WorkDetailNotFoundException
import com.kodomo.juganbbojjak.domain.work_report.model.WorkDetail
import com.kodomo.juganbbojjak.domain.work_report.persistence.entity.QWorkDetailEntity.workDetailEntity
import com.kodomo.juganbbojjak.domain.work_report.persistence.entity.QWorkReportEntity.workReportEntity
import com.kodomo.juganbbojjak.domain.work_report.persistence.mapper.WorkDetailMapper
import com.kodomo.juganbbojjak.domain.work_report.persistence.repository.WorkDetailRepository
import com.kodomo.juganbbojjak.domain.work_report.persistence.vo.QQueryWorkReportDetailsVO
import com.kodomo.juganbbojjak.domain.work_report.spi.WorkDetailPort
import com.kodomo.juganbbojjak.domain.work_report.spi.vo.WorkReportDetailsVO
import com.kodomo.juganbbojjak.global.annotation.Adapter
import com.querydsl.core.group.GroupBy.groupBy
import com.querydsl.core.group.GroupBy.list
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.data.repository.findByIdOrNull
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

    override fun queryWorkDetailByWeeklyWorkReportId(
        weeklyWorkReportId: UUID,
        userId: UUID?
    ): List<WorkReportDetailsVO> =
        queryFactory
            .selectFrom(workReportEntity)
            .leftJoin(workDetailEntity)
            .on(workDetailEntity.workReportEntity.id.eq(workReportEntity.id))
            .where(
                workReportEntity.weeklyWorkReportEntity.id.eq(weeklyWorkReportId),
                eqUserId(userId)
            )
            .transform(
                groupBy(workReportEntity.id)
                    .list(
                        QQueryWorkReportDetailsVO(
                            workReportEntity.id,
                            workReportEntity.title,
                            list(workDetailEntity)
                        )
                    )
            )

    private fun eqUserId(userId: UUID?): BooleanExpression? =
        if (userId != null)
            workReportEntity.userEntity.id.eq(userId)
        else null

    override fun queryWorkDetailById(workDetailIdList: UUID): WorkDetail {
        return workDetailMapper.toDomain(
            workDetailRepository.findByIdOrNull(workDetailIdList)
                ?: throw WorkDetailNotFoundException
        )

    }

    override fun saveWorkDetail(workDetail: WorkDetail) {
        workDetailRepository.save(
            workDetailMapper.toEntity(workDetail)
        )
    }
}