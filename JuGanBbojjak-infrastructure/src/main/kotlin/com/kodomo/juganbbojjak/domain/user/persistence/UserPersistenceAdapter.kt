package com.kodomo.juganbbojjak.domain.user.persistence

import com.kodomo.juganbbojjak.domain.user.model.User
import com.kodomo.juganbbojjak.domain.user.persistence.mapper.UserMapper
import com.kodomo.juganbbojjak.domain.user.persistence.repository.UserJpaRepository
import com.kodomo.juganbbojjak.domain.user.spi.UserPort
import com.kodomo.juganbbojjak.global.annotation.Adapter
import org.springframework.data.repository.findByIdOrNull
import java.util.UUID

@Adapter
class UserPersistenceAdapter(
    private val userJpaRepository: UserJpaRepository,
    private val userMapper: UserMapper,
) : UserPort {

    fun queryUserById(id: UUID): User? = userMapper.toDomain(
        userJpaRepository.findByIdOrNull(id)
    )
}