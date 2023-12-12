package com.kodomo.juganbbojjak.domain.event_schedule.persistence

import com.kodomo.juganbbojjak.domain.event_schedule.model.EventSchedule
import com.kodomo.juganbbojjak.domain.event_schedule.model.WeeklyEventSchedule
import com.kodomo.juganbbojjak.domain.event_schedule.persistence.entity.QEventScheduleEntity.eventScheduleEntity
import com.kodomo.juganbbojjak.domain.event_schedule.persistence.entity.QWeeklyEventScheduleEntity.weeklyEventScheduleEntity
import com.kodomo.juganbbojjak.domain.event_schedule.persistence.mapper.EventScheduleMapper
import com.kodomo.juganbbojjak.domain.event_schedule.persistence.mapper.WeeklyEventScheduleMapper
import com.kodomo.juganbbojjak.domain.event_schedule.persistence.repository.EventScheduleJpaRepository
import com.kodomo.juganbbojjak.domain.event_schedule.persistence.repository.WeeklyEventScheduleJpaRepository
import com.kodomo.juganbbojjak.domain.event_schedule.spi.EventSchedulePort
import com.kodomo.juganbbojjak.global.annotation.Adapter
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.data.repository.findByIdOrNull
import java.util.UUID

@Adapter
class EvenSchedulePersistenceAdapter(
    private val eventScheduleJpaRepository: EventScheduleJpaRepository,
    private val weeklyEventScheduleJpaRepository: WeeklyEventScheduleJpaRepository,
    private val eventScheduleMapper: EventScheduleMapper,
    private val weeklyEventScheduleMapper: WeeklyEventScheduleMapper,
    private val queryFactory: JPAQueryFactory
) : EventSchedulePort {

    override fun queryWeeklyEventScheduleById(weeklyEventScheduleId: UUID): WeeklyEventSchedule? =
        weeklyEventScheduleMapper.toDomain(
            weeklyEventScheduleJpaRepository.findByIdOrNull(weeklyEventScheduleId)
        )

    override fun queryEventSchedulesByWeeklyEventScheduleId(
        weeklyEventScheduleId: UUID,
        userId: UUID?
    ): List<EventSchedule> {
        return queryFactory
            .selectFrom(eventScheduleEntity)
            .join(eventScheduleEntity.weeklyEventScheduleEntity, weeklyEventScheduleEntity)
            .where(
                weeklyEventScheduleEntity.id.eq(weeklyEventScheduleId),
                eqUserId(userId)
            )
            .orderBy(eventScheduleEntity.date.asc())
            .fetch().stream()
            .map { eventScheduleMapper.toDomain(it)!! }
            .toList()
    }

    override fun saveAllEventSchedule(eventSchedule: List<EventSchedule>) {
        eventScheduleJpaRepository.saveAll(eventSchedule.stream().map { eventScheduleMapper.toEntity(it) }.toList())
    }

    //==condition==//

    private fun eqUserId(userId: UUID?): BooleanExpression? =
        if (userId != null)
            eventScheduleEntity.userEntity.id.eq(userId)
        else null
}