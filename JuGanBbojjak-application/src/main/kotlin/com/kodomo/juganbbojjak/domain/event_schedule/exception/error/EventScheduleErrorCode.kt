package com.kodomo.juganbbojjak.domain.event_schedule.exception.error

import com.kodomo.juganbbojjak.common.error.ErrorProperty

enum class EventScheduleErrorCode(
    override val status: Int,
    override val message: String,
) : ErrorProperty {
}