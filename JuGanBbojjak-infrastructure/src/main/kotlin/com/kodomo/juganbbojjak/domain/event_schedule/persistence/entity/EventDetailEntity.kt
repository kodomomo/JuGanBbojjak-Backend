package com.kodomo.juganbbojjak.domain.event_schedule.persistence.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull
import java.time.LocalDate
import java.util.UUID

@Table(name = "tbl_event_detail")
@Entity
class EventDetailEntity(

    @Id
    val id: UUID = UUID.randomUUID(),

    @field:NotNull
    @Column(columnDefinition = "DATE")
    val date: LocalDate,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(20)")
    val name: String,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(30)")
    val place: String,

    @field:NotNull
    @Column(columnDefinition = "INT")
    val headcount: Int,

    @field:NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_date_id")
    val eventScheduleEntity: EventScheduleEntity
)