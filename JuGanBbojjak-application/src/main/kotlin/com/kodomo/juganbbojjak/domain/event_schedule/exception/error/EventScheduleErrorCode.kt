package com.kodomo.juganbbojjak.domain.event_schedule.exception.error

import com.kodomo.juganbbojjak.common.error.ErrorProperty

enum class EventScheduleErrorCode(
    override val status: Int,
    override val message: String,
) : ErrorProperty {

    WEEKLY_EVENT_SCHEDULE_NOT_FOUND(404, "Weekly Event Schedule Not Found"),
    EVENT_SCHEDULE_NOT_FOUND(404, "Event Schedule Not Found"),
}