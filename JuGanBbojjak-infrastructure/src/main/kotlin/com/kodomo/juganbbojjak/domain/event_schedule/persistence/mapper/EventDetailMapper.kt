package com.kodomo.juganbbojjak.domain.event_schedule.persistence.mapper

import com.kodomo.juganbbojjak.domain.event_schedule.exception.EventScheduleNotFoundException
import com.kodomo.juganbbojjak.domain.event_schedule.model.EventDetail
import com.kodomo.juganbbojjak.domain.event_schedule.persistence.entity.EventDetailEntity
import com.kodomo.juganbbojjak.domain.event_schedule.persistence.repository.EventScheduleJpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class EventDetailMapper(
    private val eventScheduleJpaRepository: EventScheduleJpaRepository,
) {

    fun toDomain(entity: EventDetailEntity?): EventDetail? =
        entity?.run {
            EventDetail(
                id = id,
                date = date,
                name = name,
                place = place,
                headcount = headcount,
                eventScheduleId = eventScheduleEntity.id,
            )
        }

    fun toEntity(domain: EventDetail): EventDetailEntity {
        val eventScheduleEntity = eventScheduleJpaRepository.findByIdOrNull(domain.eventScheduleId)
            ?: throw EventScheduleNotFoundException

        return EventDetailEntity(
            id = domain.id,
            date = domain.date,
            name = domain.name,
            place = domain.place,
            headcount = domain.headcount,
            eventScheduleEntity = eventScheduleEntity,
        )
    }
}