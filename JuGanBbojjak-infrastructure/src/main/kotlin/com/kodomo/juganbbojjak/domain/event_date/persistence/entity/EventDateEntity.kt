package com.kodomo.juganbbojjak.domain.event_date.persistence.entity

import com.kodomo.juganbbojjak.domain.user.persistence.entity.UserEntity
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull
import java.util.UUID

@Table(name = "tbl_event_date")
@Entity
class EventDateEntity(

    @Id
    val id: UUID = UUID.randomUUID(),

    @field:NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "weekly_event_date_id")
    val weeklyEventDateEntity: WeeklyEventDateEntity,

    @field:NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val userEntity: UserEntity,
)