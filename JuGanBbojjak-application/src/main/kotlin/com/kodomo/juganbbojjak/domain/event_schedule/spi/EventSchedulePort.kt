package com.kodomo.juganbbojjak.domain.event_schedule.spi

import com.kodomo.juganbbojjak.domain.event_schedule.model.EventSchedule
import com.kodomo.juganbbojjak.domain.event_schedule.model.WeeklyEventSchedule
import java.util.UUID

interface EventSchedulePort : QueryEventSchedulePort, CommandEventSchedulePort {

}

interface QueryEventSchedulePort {
    fun queryWeeklyEventScheduleById(weeklyEventScheduleId: UUID): WeeklyEventSchedule?
}

interface CommandEventSchedulePort {
    fun saveAllEventSchedule(eventSchedule: List<EventSchedule>)
}