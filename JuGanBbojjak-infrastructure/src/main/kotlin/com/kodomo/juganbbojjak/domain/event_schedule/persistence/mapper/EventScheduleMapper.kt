package com.kodomo.juganbbojjak.domain.event_schedule.persistence.mapper

import com.kodomo.juganbbojjak.domain.event_schedule.exception.WeeklyEventScheduleNotFoundException
import com.kodomo.juganbbojjak.domain.event_schedule.model.EventSchedule
import com.kodomo.juganbbojjak.domain.event_schedule.persistence.entity.EventScheduleEntity
import com.kodomo.juganbbojjak.domain.event_schedule.persistence.repository.WeeklyEventScheduleJpaRepository
import com.kodomo.juganbbojjak.domain.user.exception.UserNotFoundException
import com.kodomo.juganbbojjak.domain.user.persistence.repository.UserJpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class EventScheduleMapper(
    private val weeklyEventScheduleJpaRepository: WeeklyEventScheduleJpaRepository,
    private val userJpaRepository: UserJpaRepository,
) {

    fun toDomain(entity: EventScheduleEntity?): EventSchedule? =
        entity?.run {
            EventSchedule(
                id = id,
                weeklyEventScheduleId = weeklyEventScheduleEntity.id,
                userId = userEntity.id,
            )
        }

    fun toEntity(domain: EventSchedule): EventScheduleEntity {
        val weeklyEventScheduleEntity = weeklyEventScheduleJpaRepository.findByIdOrNull(domain.weeklyEventScheduleId) ?: throw WeeklyEventScheduleNotFoundException
        val userEntity = userJpaRepository.findByIdOrNull(domain.userId) ?: throw UserNotFoundException

        return EventScheduleEntity(
            id = domain.id,
            weeklyEventScheduleEntity = weeklyEventScheduleEntity,
            userEntity = userEntity,
        )
    }
}