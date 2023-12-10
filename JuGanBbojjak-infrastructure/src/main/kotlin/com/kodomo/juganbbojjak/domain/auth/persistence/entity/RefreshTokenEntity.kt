package com.kodomo.juganbbojjak.domain.auth.persistence.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import org.springframework.data.redis.core.index.Indexed
import java.util.UUID


@RedisHash
class RefreshTokenEntity(
    @Id
    val id: UUID,

    @Indexed
    val token: String,

    @TimeToLive
    var ttl: Long,
)