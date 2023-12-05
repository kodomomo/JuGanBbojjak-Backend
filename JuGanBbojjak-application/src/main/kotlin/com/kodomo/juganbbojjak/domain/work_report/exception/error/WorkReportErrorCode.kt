package com.kodomo.juganbbojjak.domain.work_report.exception.error

import com.kodomo.juganbbojjak.common.error.ErrorProperty

enum class WorkReportErrorCode(
    override val status: Int,
    override val message: String,
) : ErrorProperty {
}