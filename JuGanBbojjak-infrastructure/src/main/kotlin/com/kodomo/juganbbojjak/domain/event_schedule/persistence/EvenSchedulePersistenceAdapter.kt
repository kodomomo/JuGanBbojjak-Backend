package com.kodomo.juganbbojjak.domain.event_schedule.persistence

import com.kodomo.juganbbojjak.domain.event_schedule.model.EventDetail
import com.kodomo.juganbbojjak.domain.event_schedule.model.EventSchedule
import com.kodomo.juganbbojjak.domain.event_schedule.model.WeeklyEventSchedule
import com.kodomo.juganbbojjak.domain.event_schedule.persistence.mapper.EventDetailMapper
import com.kodomo.juganbbojjak.domain.event_schedule.persistence.mapper.EventScheduleMapper
import com.kodomo.juganbbojjak.domain.event_schedule.persistence.mapper.WeeklyEventScheduleMapper
import com.kodomo.juganbbojjak.domain.event_schedule.persistence.repository.EventDetailJpaRepository
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
    private val eventDetailJpaRepository: EventDetailJpaRepository,
    private val eventScheduleMapper: EventScheduleMapper,
    private val weeklyEventScheduleMapper: WeeklyEventScheduleMapper,
    private val eventDetailMapper: EventDetailMapper,
) : EventSchedulePort {

    override fun queryWeeklyEventScheduleById(weeklyEventScheduleId: UUID): WeeklyEventSchedule? =
        weeklyEventScheduleMapper.toDomain(
            weeklyEventScheduleJpaRepository.findByIdOrNull(weeklyEventScheduleId)
        )

    override fun saveEventSchedule(eventSchedule: EventSchedule): EventSchedule = eventScheduleMapper.toDomain(
        eventScheduleJpaRepository.save(eventScheduleMapper.toEntity(eventSchedule))
    )!!

    override fun saveAllEventDetail(eventDetails: List<EventDetail>) {
        eventDetailJpaRepository.saveAll(eventDetails.stream()
            .map {
                eventDetailMapper.toEntity(it)
            }.toList()
        )
    }


}