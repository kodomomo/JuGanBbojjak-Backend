package com.kodomo.juganbbojjak.domain.work_report.persistence.repository

import com.kodomo.juganbbojjak.domain.work_report.persistence.entity.WeeklyWorkReportEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface WeeklyWorkReportRepository : JpaRepository<WeeklyWorkReportEntity, UUID> {
    fun findAllByOrderByEndDateDesc(): List<WeeklyWorkReportEntity>
    fun findTopByOrderByEndDateDesc(): WeeklyWorkReportEntity?
}