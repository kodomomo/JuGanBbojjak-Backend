package com.kodomo.juganbbojjak.domain.work_report.persistence.mapper

import com.kodomo.juganbbojjak.domain.work_report.exception.WorkReportNotFoundException
import com.kodomo.juganbbojjak.domain.work_report.model.WorkDetail
import com.kodomo.juganbbojjak.domain.work_report.persistence.entity.WorkDetailEntity
import com.kodomo.juganbbojjak.domain.work_report.persistence.repository.WorkReportRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class WorkDetailMapper(
    private val workReportRepository: WorkReportRepository
) {

    fun toDomain(entity: WorkDetailEntity): WorkDetail =
        entity.run {
            WorkDetail(
                id = id,
                title = title,
                content = content,
                type = type,
                workReportId = workReportEntity.id
            )
        }

    fun toEntity(domain: WorkDetail): WorkDetailEntity {
        val workReportEntity =
            workReportRepository.findByIdOrNull(domain.workReportId)
                ?: throw WorkReportNotFoundException

        return WorkDetailEntity(
            id = domain.id,
            title = domain.title,
            content = domain.content,
            type = domain.type,
            workReportEntity = workReportEntity
        )
    }
}