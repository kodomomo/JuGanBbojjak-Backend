package com.kodomo.juganbbojjak.domain.work_report.presentation.dto

import com.kodomo.juganbbojjak.domain.work_report.dto.CreateWeeklyWorkReportRequest
import org.jetbrains.annotations.NotNull
import java.time.LocalDate

data class CreateWeeklyWorkReportWebRequest(

    @field:NotNull
    val startDate: LocalDate,

    @field:NotNull
    val endDate: LocalDate,
) {

    fun toDomainRequest() = CreateWeeklyWorkReportRequest(
        startDate = startDate,
        endDate = endDate,
    )
}