package com.kodomo.juganbbojjak.domain.work_report.persistence.entity

import com.kodomo.juganbbojjak.domain.user.persistence.entity.UserEntity
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import java.util.UUID

@Table(name = "tbl_work_report")
@Entity
class WorkReportEntity(

    @Id
    val id: UUID = UUID.randomUUID(),

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(20)")
    val title: String,

    @field:NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "weekly_work_report_id")
    val weeklyWorkReportEntity: WeeklyWorkReportEntity,

    @field:NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val userEntity: UserEntity,
)