package com.kodomo.juganbbojjak.domain.work_report.persistence.repository

import com.kodomo.juganbbojjak.domain.work_report.persistence.entity.WorkDetailEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface WorkDetailRepository : JpaRepository<WorkDetailEntity, UUID> {
}