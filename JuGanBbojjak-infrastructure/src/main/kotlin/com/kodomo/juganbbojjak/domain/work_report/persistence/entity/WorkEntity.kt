package com.kodomo.juganbbojjak.domain.work_report.persistence.entity

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull
import java.util.UUID

@Table(name = "tbl_work")
@Entity
class WorkEntity(

    @Id
    val id: UUID = UUID.randomUUID(),

    @field:NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_report_id")
    val workReportEntity: WorkReportEntity,
)