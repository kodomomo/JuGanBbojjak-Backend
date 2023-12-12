package com.kodomo.juganbbojjak.domain.event_schedule.persistence

import com.kodomo.juganbbojjak.domain.event_schedule.model.EventSchedule
import com.kodomo.juganbbojjak.domain.event_schedule.model.WeeklyEventSchedule
import com.kodomo.juganbbojjak.domain.event_schedule.persistence.mapper.EventScheduleMapper
import com.kodomo.juganbbojjak.domain.event_schedule.persistence.mapper.WeeklyEventScheduleMapper
import com.kodomo.juganbbojjak.domain.event_schedule.persistence.repository.EventScheduleJpaRepository
import com.kodomo.juganbbojjak.domain.event_schedule.persistence.repository.WeeklyEventScheduleJpaRepository
import com.kodomo.juganbbojjak.domain.event_schedule.spi.EventSchedulePort
import com.kodomo.juganbbojjak.global.annotation.Adapter
import org.springframework.data.repository.findByIdOrNull
import java.util.UUID

@Adapter
class EvenSchedulePersistenceAdapter(
    private val eventScheduleJpaRepository: EventScheduleJpaRepository,
    private val weeklyEventScheduleJpaRepository: WeeklyEventScheduleJpaRepository,
    private val eventScheduleMapper: EventScheduleMapper,
    private val weeklyEventScheduleMapper: WeeklyEventScheduleMapper,
) : EventSchedulePort {

    override fun queryWeeklyEventScheduleById(weeklyEventScheduleId: UUID): WeeklyEventSchedule? =
        weeklyEventScheduleMapper.toDomain(
            weeklyEventScheduleJpaRepository.findByIdOrNull(weeklyEventScheduleId)
        )

    override fun saveAllEventSchedule(eventSchedule: List<EventSchedule>) {
        eventScheduleJpaRepository.saveAll(eventSchedule.stream().map { eventScheduleMapper.toEntity(it) }.toList())
    }
}