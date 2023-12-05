package com.kodomo.juganbbojjak.domain.work_report.persistence.entity

import com.kodomo.juganbbojjak.domain.work_report.model.WorkDetailType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull
import java.util.UUID

@Table(name = "tbl_work_detail")
@Entity
class WorkDetailEntity(

    @Id
    val id: UUID = UUID.randomUUID(),

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(20)")
    val title: String,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(4000)")
    val content: String,

    @field:NotNull
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(7)")
    val type: WorkDetailType,

    @field:NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_id")
    val workEntity: WorkEntity,
)