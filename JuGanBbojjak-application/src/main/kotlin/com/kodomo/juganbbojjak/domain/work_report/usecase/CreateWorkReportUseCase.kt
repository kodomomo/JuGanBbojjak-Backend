package com.kodomo.juganbbojjak.domain.work_report.usecase

import com.kodomo.juganbbojjak.common.annotation.UseCase
import com.kodomo.juganbbojjak.common.spi.SecurityPort
import com.kodomo.juganbbojjak.domain.work_report.dto.request.CreateWorkReportRequest
import com.kodomo.juganbbojjak.domain.work_report.model.WorkDetail
import com.kodomo.juganbbojjak.domain.work_report.model.WorkReport
import com.kodomo.juganbbojjak.domain.work_report.spi.QueryWeeklyWorkReportPort
import com.kodomo.juganbbojjak.domain.work_report.spi.WorkDetailPort
import com.kodomo.juganbbojjak.domain.work_report.spi.WorkReportPort
import java.util.UUID

@UseCase
class CreateWorkReportUseCase(
    private val securityPort: SecurityPort,
    private val weeklyWorkReportPort: QueryWeeklyWorkReportPort,
    private val workReportPort: WorkReportPort,
    private val workDetailPort: WorkDetailPort
) {

    fun execute(weeklyWorkReportId: UUID, request: CreateWorkReportRequest) {
        val user = securityPort.getCurrentUserId()
        val weeklyWorkReport = weeklyWorkReportPort.queryWeeklyWorkReportById(weeklyWorkReportId)

        val workReport = workReportPort.saveWorkReport(
            WorkReport(
                title = request.title,
                weeklyWorkReportId = weeklyWorkReport.id,
                userId = user
            )
        )

        workDetailPort.saveAllWorkDetails(
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