package com.kodomo.juganbbojjak.domain.work_report.persistence.entity

import com.kodomo.juganbbojjak.domain.user.persistence.entity.UserEntity
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull
import java.util.UUID

@Table(name = "tbl_work_report")
@Entity
class WorkReportEntity(

    @Id
    val id: UUID = UUID.randomUUID(),

    @field:NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "weekly_work_report_id")
    val weeklyWorkReportEntity: WeeklyWorkReportEntity,

    @field:NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val userEntity: UserEntity,
)