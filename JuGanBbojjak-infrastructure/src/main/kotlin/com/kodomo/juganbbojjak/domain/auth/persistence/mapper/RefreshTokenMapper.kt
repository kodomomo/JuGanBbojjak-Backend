package com.kodomo.juganbbojjak.domain.auth.persistence.mapper

import com.kodomo.juganbbojjak.domain.auth.model.RefreshToken
import com.kodomo.juganbbojjak.domain.auth.persistence.entity.RefreshTokenEntity
import org.springframework.stereotype.Component

@Component
class RefreshTokenMapper {

    fun toDomain(entity: RefreshTokenEntity?): RefreshToken? =
        entity?.run {
            RefreshToken(
                id = id,
                token = token,
                ttl = ttl,
            )
        }

    fun toEntity(domain: RefreshToken): RefreshTokenEntity =
        RefreshTokenEntity(
            id = domain.id,
            token = domain.token,
            ttl = domain.ttl,
        )
}