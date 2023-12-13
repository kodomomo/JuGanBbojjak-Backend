package com.kodomo.juganbbojjak.domain.user.dto.response

import com.kodomo.juganbbojjak.domain.user.model.WeeklyListType
import java.time.LocalDate
import java.util.UUID

data class QueryWeeklyListResponse (
    val weeklyList: List<WeeklyList>
)

data class WeeklyList(
    val id: UUID,
    val startDate: LocalDate,
    val endDate: LocalDate,
    val type: WeeklyListType
)