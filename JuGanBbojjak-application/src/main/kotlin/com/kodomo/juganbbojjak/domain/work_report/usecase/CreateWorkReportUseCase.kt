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

        request.workReportList.forEach { workReportList ->
            val workReport = commandWorkReportPort.saveWorkReport(
                WorkReport(
                    title = workReportList.title,
                    weeklyWorkReportId = weeklyWorkReport.id,
                    userId = user
                )
            )

            val workDetails = workReportList.workReportDetails.map { detail ->
                WorkDetail(
                    title = detail.contentKey,
                    content = detail.contentValue,
                    type = detail.contentType,
                    workReportId = workReport.id
                )
            }
            commandWorkDetailPort.saveAllWorkDetails(workDetails)
        }
    }
}
