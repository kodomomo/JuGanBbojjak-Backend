package com.kodomo.juganbbojjak.domain.work_report.usecase

import com.kodomo.juganbbojjak.common.annotation.UseCase
import com.kodomo.juganbbojjak.common.spi.SecurityPort
import com.kodomo.juganbbojjak.domain.work_report.dto.request.CreateWorkReportRequest
import com.kodomo.juganbbojjak.domain.work_report.model.WorkDetail
import com.kodomo.juganbbojjak.domain.work_report.model.WorkReport
import com.kodomo.juganbbojjak.domain.work_report.spi.*
import java.util.UUID

@UseCase
class CreateWorkReportUseCase(
    private val securityPort: SecurityPort,
    private val weeklyWorkReportPort: QueryWeeklyWorkReportPort,
    private val commandWorkReportPort: CommandWorkReportPort,
    private val commandWorkDetailPort: CommandWorkDetailPort
) {

    fun execute(weeklyWorkReportId: UUID, request: CreateWorkReportRequest) {
        val user = securityPort.getCurrentUserId()
        val weeklyWorkReport = weeklyWorkReportPort.queryWeeklyWorkReportById(weeklyWorkReportId)

        val workReport = commandWorkReportPort.saveWorkReport(
            WorkReport(
                title = request.title,
                weeklyWorkReportId = weeklyWorkReport.id,
                userId = user
            )
        )

        commandWorkDetailPort.saveAllWorkDetails(
            request.workReportList.map {
                WorkDetail(
                    title = it.contentKey,
                    content = it.contentValue,
                    type = it.contentType,
                    workReportId = workReport.id
                )
            }
        )
    }
}