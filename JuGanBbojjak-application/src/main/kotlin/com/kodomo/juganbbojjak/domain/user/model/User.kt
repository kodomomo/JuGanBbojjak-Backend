package com.kodomo.juganbbojjak.domain.user.model

import com.kodomo.juganbbojjak.common.annotation.Aggregate
import java.util.UUID

@Aggregate
data class User(
    val id: UUID,
    val name: String,
    val accountId: String,
    val password: String,
    val authority: Authority,
    val teamId: UUID,
)