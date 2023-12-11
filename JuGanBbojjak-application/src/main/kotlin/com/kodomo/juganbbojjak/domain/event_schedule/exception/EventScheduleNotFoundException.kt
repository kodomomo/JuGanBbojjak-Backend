package com.kodomo.juganbbojjak.domain.event_schedule.exception

import com.kodomo.juganbbojjak.common.error.JuGanBbojjakException
import com.kodomo.juganbbojjak.domain.event_schedule.exception.error.EventScheduleErrorCode

object EventScheduleNotFoundException : JuGanBbojjakException(
    EventScheduleErrorCode.EVENT_SCHEDULE_NOT_FOUND
)