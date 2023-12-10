package com.kodomo.juganbbojjak.domain.user.persistence.mapper

import com.kodomo.juganbbojjak.domain.user.exception.TeamNotFoundException
import com.kodomo.juganbbojjak.domain.user.model.Authority
import com.kodomo.juganbbojjak.domain.user.model.User
import com.kodomo.juganbbojjak.domain.user.persistence.entity.TeamEntity
import com.kodomo.juganbbojjak.domain.user.persistence.entity.UserEntity
import com.kodomo.juganbbojjak.domain.user.persistence.repository.TeamJpaRepository
import com.kodomo.juganbbojjak.domain.user.persistence.repository.UserJpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class UserMapper(
    private val teamJpaRepository: TeamJpaRepository
) {

    fun toDomain(entity: UserEntity?): User? =
        entity?.run {
            User(
                id = id,
                name = name,
                accountId = accountId,
                password = password,
                authority = authority,
                teamId = teamEntity.id,
            )
        }

    fun toEntity(domain: User): UserEntity {
        val teamEntity = teamJpaRepository.findByIdOrNull(domain.teamId) ?: throw TeamNotFoundException
        return UserEntity(
            id = domain.id,
            name = domain.name,
            accountId = domain.accountId,
            password = domain.password,
            authority = domain.authority,
            teamEntity = teamEntity
        )
    }
}