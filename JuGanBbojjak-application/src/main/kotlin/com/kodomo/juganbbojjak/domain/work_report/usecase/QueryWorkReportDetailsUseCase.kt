package com.kodomo.juganbbojjak.domain.work_report.usecase

import com.kodomo.juganbbojjak.common.annotation.UseCase
import com.kodomo.juganbbojjak.common.spi.SecurityPort
import com.kodomo.juganbbojjak.domain.user.exception.UserNotFoundException
import com.kodomo.juganbbojjak.domain.user.model.Authority
import com.kodomo.juganbbojjak.domain.user.spi.QueryUserPort
import com.kodomo.juganbbojjak.domain.work_report.dto.reponse.QueryWorkReportDetailsResponse
import com.kodomo.juganbbojjak.domain.work_report.dto.reponse.WorkReportListResponse
import com.kodomo.juganbbojjak.domain.work_report.exception.WorkReportNotFoundException
import com.kodomo.juganbbojjak.domain.work_report.spi.*
import java.util.UUID

@UseCase
class QueryWorkReportDetailsUseCase(
    private val queryWorkReportPort: QueryWorkReportPort,
    private val queryWorkDetailPort: QueryWorkDetailPort,
    private val securityPort: SecurityPort,
    private val queryUserPort: QueryUserPort
) {

    fun execute(weeklyWorkReportId: UUID): QueryWorkReportDetailsResponse {

        val user = queryUserPort.queryUserById(securityPort.getCurrentUserId())
            ?: throw UserNotFoundException

        val workReport = when (user.authority) {
            Authority.ADMIN -> queryWorkReportPort.queryWorkReportByWeeklyWorkReportId(weeklyWorkReportId, null)
            Authority.USER -> queryWorkReportPort.queryWorkReportByWeeklyWorkReportId(weeklyWorkReportId, user.id)
        } ?: throw WorkReportNotFoundException

        val workDetail = queryWorkDetailPort.queryWorkDetailByWorkReportId(workReport.id)

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