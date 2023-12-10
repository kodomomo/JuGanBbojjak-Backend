package com.kodomo.juganbbojjak.domain.auth.model

import com.kodomo.juganbbojjak.common.annotation.Aggregate
import java.util.UUID

@Aggregate
class RefreshToken(
    val id: UUID,
    val token: String,
    val ttl: Long,
)