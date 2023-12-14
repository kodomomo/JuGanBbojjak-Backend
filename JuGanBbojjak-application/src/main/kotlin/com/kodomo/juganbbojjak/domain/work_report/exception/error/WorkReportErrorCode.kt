package com.kodomo.juganbbojjak.domain.work_report.exception.error

import com.kodomo.juganbbojjak.common.error.ErrorProperty

enum class WorkReportErrorCode(
    override val status: Int,
    override val message: String,
) : ErrorProperty {

    WEEKLY_WORK_REPORT_NOT_FOUND(404, "Weekly Work Report Not Found"),
    WORK_REPORT_NOT_FOUND(404, "Work Report Not Found"),
    WORK_DETAIL_NOT_FOUND(404, "Work Detail Not Found")
}