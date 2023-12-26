package com.kodomo.juganbbojjak.domain.work_report.usecase

import com.kodomo.juganbbojjak.common.annotation.UseCase
import com.kodomo.juganbbojjak.domain.work_report.dto.CreateWeeklyWorkReportRequest
import com.kodomo.juganbbojjak.domain.work_report.model.WeeklyWorkReport
import com.kodomo.juganbbojjak.domain.work_report.spi.CommandWeeklyWorkReportPort

@UseCase
class CreateWeeklyWorkReportUseCase(
    private val commandWorkReportPort: CommandWeeklyWorkReportPort,
) {

    fun execute(request: CreateWeeklyWorkReportRequest) {
        commandWorkReportPort.saveWeeklyWorkReport(
            WeeklyWorkReport(
                startDate = request.startDate,
                endDate = request.endDate,
            )
        )
    }
}