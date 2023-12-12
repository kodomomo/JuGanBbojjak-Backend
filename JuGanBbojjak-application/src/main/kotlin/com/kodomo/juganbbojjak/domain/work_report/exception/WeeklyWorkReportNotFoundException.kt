package com.kodomo.juganbbojjak.domain.work_report.exception

import com.kodomo.juganbbojjak.common.error.JuGanBbojjakException
import com.kodomo.juganbbojjak.domain.work_report.exception.error.WorkReportErrorCode

object WeeklyWorkReportNotFoundException : JuGanBbojjakException(
    WorkReportErrorCode.WEEKLY_WORK_REPORT_NOT_FOUND
)