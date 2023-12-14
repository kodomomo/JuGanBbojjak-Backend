package com.kodomo.juganbbojjak.domain.work_report.usecase

import com.kodomo.juganbbojjak.common.annotation.UseCase
import com.kodomo.juganbbojjak.domain.work_report.dto.request.UpdateWorkReportRequest
import com.kodomo.juganbbojjak.domain.work_report.spi.CommandWorkDetailPort
import com.kodomo.juganbbojjak.domain.work_report.spi.CommandWorkReportPort
import com.kodomo.juganbbojjak.domain.work_report.spi.QueryWorkDetailPort
import com.kodomo.juganbbojjak.domain.work_report.spi.QueryWorkReportPort

@UseCase
class UpdateWorkReportUseCase(
    private val queryWorkReportPort: QueryWorkReportPort,
    private val commandWorkReportPort: CommandWorkReportPort,
    private val queryWorkDetailPort: QueryWorkDetailPort,
    private val commandWorkDetailPort: CommandWorkDetailPort
) {

    fun execute(request: UpdateWorkReportRequest) {
        val workReportEntity = queryWorkReportPort.queryWorkReportById(request.workReportId)

        commandWorkReportPort.saveWorkReport(workReportEntity.updateWorkReport(request.title))

        request.workReportDetails.forEach { workReportDetails ->
            val workDetailList =
                queryWorkDetailPort.queryWorkDetailById(workReportDetails.workDetailId)

            commandWorkDetailPort.saveWorkDetail(
                workDetailList.updateWorkDetail(workReportDetails)
            )
        }
    }
}