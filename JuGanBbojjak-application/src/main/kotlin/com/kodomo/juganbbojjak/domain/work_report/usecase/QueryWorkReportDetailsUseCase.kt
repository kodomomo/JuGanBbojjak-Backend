package com.kodomo.juganbbojjak.domain.work_report.usecase

import com.kodomo.juganbbojjak.common.annotation.UseCase
import com.kodomo.juganbbojjak.common.spi.SecurityPort
import com.kodomo.juganbbojjak.domain.user.exception.UserNotFoundException
import com.kodomo.juganbbojjak.domain.user.model.Authority
import com.kodomo.juganbbojjak.domain.user.spi.QueryUserPort
import com.kodomo.juganbbojjak.domain.work_report.dto.response.QueryWorkReportDetailsResponse
import com.kodomo.juganbbojjak.domain.work_report.dto.response.WorkReportDetailsResponse
import com.kodomo.juganbbojjak.domain.work_report.dto.response.WorkReportListResponse
import com.kodomo.juganbbojjak.domain.work_report.spi.*
import java.util.UUID

@UseCase
class QueryWorkReportDetailsUseCase(
    private val queryWorkDetailPort: QueryWorkDetailPort,
    private val securityPort: SecurityPort,
    private val queryUserPort: QueryUserPort
) {

    fun execute(weeklyWorkReportId: UUID): QueryWorkReportDetailsResponse {

        val user = queryUserPort.queryUserById(securityPort.getCurrentUserId())
            ?: throw UserNotFoundException

        val workReportList = when (user.authority) {
            Authority.ADMIN -> queryWorkDetailPort.queryWorkDetailByWeeklyWorkReportId(weeklyWorkReportId, null)
            Authority.USER -> queryWorkDetailPort.queryWorkDetailByWeeklyWorkReportId(weeklyWorkReportId, user.id)
        }

        return QueryWorkReportDetailsResponse(
            workReportList = workReportList.map { workReport ->
                WorkReportListResponse(
                    workReportId = workReport.workReportId,
                    title = workReport.title,
                    workReportDetails = workReport.workDetailsList.map { workDetail ->
                        WorkReportDetailsResponse(
                            workDetailId = workDetail.id,
                            contentKey = workDetail.title,
                            contentValue = workDetail.content,
                            contentType = workDetail.type
                        )
                    }
                )
            }
        )
    }
}