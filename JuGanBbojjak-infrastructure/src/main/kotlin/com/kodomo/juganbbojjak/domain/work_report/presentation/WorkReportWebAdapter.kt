package com.kodomo.juganbbojjak.domain.work_report.presentation

import com.kodomo.juganbbojjak.domain.work_report.dto.response.QueryWorkReportDetailsResponse
import com.kodomo.juganbbojjak.domain.work_report.presentation.dto.CreateWeeklyWorkReportWebRequest
import com.kodomo.juganbbojjak.domain.work_report.presentation.dto.CreateWorkReportWebRequest
import com.kodomo.juganbbojjak.domain.work_report.presentation.dto.UpdateWorkReportWebRequest
import com.kodomo.juganbbojjak.domain.work_report.usecase.CreateWeeklyWorkReportUseCase
import com.kodomo.juganbbojjak.domain.work_report.usecase.CreateWorkReportUseCase
import com.kodomo.juganbbojjak.domain.work_report.usecase.QueryWorkReportDetailsUseCase
import com.kodomo.juganbbojjak.domain.work_report.usecase.UpdateWorkReportUseCase
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RequestMapping("/work_report")
@RestController
class WorkReportWebAdapter(
    private val createWorkReportUseCase: CreateWorkReportUseCase,
    private val queryWorkReportDetailsUseCase: QueryWorkReportDetailsUseCase,
    private val updateWorkReportUseCase: UpdateWorkReportUseCase,
    private val createWeeklyWorkReportUseCase: CreateWeeklyWorkReportUseCase,
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{weekly-work-report-id}")
    fun createWorkReport(
        @PathVariable("weekly-work-report-id") weeklyWorkReportId: UUID,
        @RequestBody @Valid request: CreateWorkReportWebRequest
    ) {
        createWorkReportUseCase.execute(weeklyWorkReportId, request.toDomainRequest())
    }

    @GetMapping("/{weekly-work-report-id}")
    fun queryWorkDetails(@PathVariable("weekly-work-report-id") weeklyWorkReportId: UUID): QueryWorkReportDetailsResponse =
        queryWorkReportDetailsUseCase.execute(weeklyWorkReportId)

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping
    fun updateWorkReport(@RequestBody request: UpdateWorkReportWebRequest) {
        updateWorkReportUseCase.execute(request.toDomainRequest())
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createWeeklyWorkReport(
        @RequestBody @Valid request: CreateWeeklyWorkReportWebRequest
    ) {
        createWeeklyWorkReportUseCase.execute(request.toDomainRequest())
    }
}