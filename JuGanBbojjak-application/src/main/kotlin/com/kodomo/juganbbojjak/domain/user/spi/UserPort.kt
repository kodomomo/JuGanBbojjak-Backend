package com.kodomo.juganbbojjak.domain.user.spi

import com.kodomo.juganbbojjak.domain.user.model.User
import java.util.UUID

interface UserPort : CommandUserPort, QueryUserPort

interface QueryUserPort {
    fun queryUserById(id: UUID): User?
    fun queryUserByAccountId(accountId: String): User?
}

interface CommandUserPort {

}