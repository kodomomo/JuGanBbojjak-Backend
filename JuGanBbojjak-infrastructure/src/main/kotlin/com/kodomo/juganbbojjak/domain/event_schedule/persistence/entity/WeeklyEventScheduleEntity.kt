package com.kodomo.juganbbojjak.domain.event_schedule.persistence.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull
import java.time.LocalDate
import java.util.UUID

@Table(name = "tbl_weekly_event_date")
@Entity
class WeeklyEventScheduleEntity(

    @Id
    val id: UUID = UUID.randomUUID(),

    @field:NotNull
    @Column(columnDefinition = "DATE")
    val startDate: LocalDate,

    @field:NotNull
    @Column(columnDefinition = "DATE")
    val endDate: LocalDate,
)