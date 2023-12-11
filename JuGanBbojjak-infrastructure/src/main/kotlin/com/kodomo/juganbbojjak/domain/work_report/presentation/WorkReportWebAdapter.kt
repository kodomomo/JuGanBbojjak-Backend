package com.kodomo.juganbbojjak.domain.work_report.presentation

import com.kodomo.juganbbojjak.domain.work_report.presentation.dto.CreateWorkReportWebRequest
import com.kodomo.juganbbojjak.domain.work_report.usecase.CreateWorkReportUseCase
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RequestMapping("/work_report")
@RestController
class WorkReportWebAdapter(
    private val createWorkReportUseCase: CreateWorkReportUseCase
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{weekly-work-report-id}")
    fun createWorkReport(
        @PathVariable("weekly-work-report-id") weeklyWorkReportId: UUID,
        @RequestBody @Valid request: CreateWorkReportWebRequest
    ) {
        createWorkReportUseCase.execute(weeklyWorkReportId, request.toDomainRequest())
    }
}