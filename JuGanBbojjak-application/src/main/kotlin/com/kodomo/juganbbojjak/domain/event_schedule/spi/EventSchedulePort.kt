package com.kodomo.juganbbojjak.domain.event_schedule.spi

import com.kodomo.juganbbojjak.domain.event_schedule.model.EventSchedule
import com.kodomo.juganbbojjak.domain.event_schedule.model.WeeklyEventSchedule
import java.util.UUID

interface EventSchedulePort : QueryEventSchedulePort, CommandEventSchedulePort {

}

interface QueryEventSchedulePort {
    fun queryWeeklyEventScheduleById(weeklyEventScheduleId: UUID): WeeklyEventSchedule?
    fun queryEventSchedulesByWeeklyEventScheduleId(weeklyEventScheduleId: UUID, userId: UUID?): List<EventSchedule>
    fun queryAllEventScheduleList(): List<WeeklyEventSchedule>
    fun queryLatestEventSchedule(): WeeklyEventSchedule?
    fun queryEventScheduleById(eventScheduleId: UUID): EventSchedule?
}

interface CommandEventSchedulePort {
    fun saveAllEventSchedule(eventSchedule: List<EventSchedule>)
    fun saveEventSchedule(eventSchedule: EventSchedule)
    fun saveWeeklyEventSchedule(weeklyEventSchedule: WeeklyEventSchedule): WeeklyEventSchedule
}