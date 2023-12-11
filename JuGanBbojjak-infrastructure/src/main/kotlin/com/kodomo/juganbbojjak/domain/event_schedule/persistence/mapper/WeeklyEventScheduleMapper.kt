package com.kodomo.juganbbojjak.domain.event_schedule.persistence.mapper

import com.kodomo.juganbbojjak.domain.event_schedule.model.WeeklyEventSchedule
import com.kodomo.juganbbojjak.domain.event_schedule.persistence.entity.WeeklyEventScheduleEntity
import org.springframework.stereotype.Component

@Component
class WeeklyEventScheduleMapper {

    fun toDomain(entity: WeeklyEventScheduleEntity?): WeeklyEventSchedule? =
        entity?.run {
            WeeklyEventSchedule(
                id = id,
                startDate = startDate,
                endDate = endDate,
            )
        }

    fun toEntity(domain: WeeklyEventSchedule): WeeklyEventScheduleEntity =
        WeeklyEventScheduleEntity(
            id = domain.id,
            startDate = domain.startDate,
            endDate = domain.endDate,
        )
}
