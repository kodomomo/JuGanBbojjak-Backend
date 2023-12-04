package com.kodomo.juganbbojjak.domain.user.persistence.entity

import com.kodomo.juganbbojjak.domain.user.model.Authority
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

@Table(name = "tbl_user")
@Entity
class UserEntity(

    @Id
    val id: UUID = UUID.randomUUID(),

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(20)")
    val name: String,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(30)")
    val accountId: String,

    @field:NotNull
    @Column(columnDefinition = "CHAR(60)")
    val password: String,

    @field:NotNull
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(5)")
    val authority: Authority,

    @field:NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    val teamEntity: TeamEntity,
)