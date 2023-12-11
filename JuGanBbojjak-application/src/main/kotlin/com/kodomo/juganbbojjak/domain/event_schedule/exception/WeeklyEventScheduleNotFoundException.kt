package com.kodomo.juganbbojjak.domain.event_schedule.exception

import com.kodomo.juganbbojjak.common.error.JuGanBbojjakException
import com.kodomo.juganbbojjak.domain.event_schedule.exception.error.EventScheduleErrorCode

object WeeklyEventScheduleNotFoundException : JuGanBbojjakException(
    EventScheduleErrorCode.WEEKLY_EVENT_SCHEDULE_NOT_FOUND
)