package com.kodomo.juganbbojjak.domain.work_report.persistence.mapper

import com.kodomo.juganbbojjak.domain.user.exception.UserNotFoundException
import com.kodomo.juganbbojjak.domain.user.persistence.repository.UserJpaRepository
import com.kodomo.juganbbojjak.domain.work_report.exception.WeeklyWorkReportNotFoundException
import com.kodomo.juganbbojjak.domain.work_report.model.WorkReport
import com.kodomo.juganbbojjak.domain.work_report.persistence.entity.WorkReportEntity
import com.kodomo.juganbbojjak.domain.work_report.persistence.repository.WeeklyWorkReportRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class WorkReportMapper(
    private val weeklyWorkReportRepository: WeeklyWorkReportRepository,
    private val userJpaRepository: UserJpaRepository
) {

    fun toDomain(entity: WorkReportEntity): WorkReport =
        entity.run {
            WorkReport(
                id = id,
                title = title,
                weeklyWorkReportId = weeklyWorkReportEntity.id,
                userId = userEntity.id
            )
        }

    fun toEntity(domain: WorkReport): WorkReportEntity {
        val weeklyWorkReportEntity = weeklyWorkReportRepository.findByIdOrNull(domain.weeklyWorkReportId)
            ?: throw WeeklyWorkReportNotFoundException

        val userEntity = userJpaRepository.findByIdOrNull(domain.userId)
            ?: throw UserNotFoundException

        return WorkReportEntity(
            id = domain.id,
            title = domain.title,
            weeklyWorkReportEntity = weeklyWorkReportEntity,
            userEntity = userEntity
        )
    }
}