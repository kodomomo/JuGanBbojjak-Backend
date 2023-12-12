package com.kodomo.juganbbojjak.domain.work_report.usecase

import com.kodomo.juganbbojjak.common.annotation.UseCase
import com.kodomo.juganbbojjak.common.spi.SecurityPort
import com.kodomo.juganbbojjak.domain.user.exception.UserNotFoundException
import com.kodomo.juganbbojjak.domain.user.model.Authority
import com.kodomo.juganbbojjak.domain.user.spi.QueryUserPort
import com.kodomo.juganbbojjak.domain.work_report.dto.reponse.QueryWorkReportDetailsResponse
import com.kodomo.juganbbojjak.domain.work_report.dto.reponse.WorkReportListResponse
import com.kodomo.juganbbojjak.domain.work_report.spi.WorkDetailPort
import com.kodomo.juganbbojjak.domain.work_report.spi.WorkReportPort
import java.util.UUID

@UseCase
class QueryWorkReportDetailsUseCase(
    private val workReportPort: WorkReportPort,
    private val workDetailPort: WorkDetailPort,
    private val securityPort: SecurityPort,
    private val queryUserPort: QueryUserPort
) {

    fun execute(weeklyWorkReportId: UUID): QueryWorkReportDetailsResponse {

        val user = queryUserPort.queryUserById(securityPort.getCurrentUserId())
            ?: throw UserNotFoundException

        val workReport = when (user.authority) {
            Authority.ADMIN -> workReportPort.queryWorkReportByWeeklyWorkReportId(weeklyWorkReportId, null)
            Authority.USER -> workReportPort.queryWorkReportByWeeklyWorkReportId(weeklyWorkReportId, user.id)
        }

        val workDetail = workDetailPort.queryWorkDetailByWorkReportId(workReport!!.id)

        return QueryWorkReportDetailsResponse(
            title = workReport.title,
            workReportList = workDetail.map {
                WorkReportListResponse(
                    contentKey = it.title,
                    contentValue = it.content,
                    contentType = it.type
                )
            }
        )
    }
}