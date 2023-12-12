package com.kodomo.juganbbojjak.domain.work_report.persistence.repository

import com.kodomo.juganbbojjak.domain.work_report.persistence.entity.WorkReportEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface WorkReportRepository : JpaRepository<WorkReportEntity, UUID> {
    fun findByWeeklyWorkReportEntityId(weeklyWorkReportId: UUID): WorkReportEntity
}