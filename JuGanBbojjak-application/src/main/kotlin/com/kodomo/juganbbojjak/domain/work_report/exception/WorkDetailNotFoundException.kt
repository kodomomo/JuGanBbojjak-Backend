package com.kodomo.juganbbojjak.domain.work_report.exception

import com.kodomo.juganbbojjak.common.error.JuGanBbojjakException
import com.kodomo.juganbbojjak.domain.work_report.exception.error.WorkReportErrorCode

object WorkDetailNotFoundException : JuGanBbojjakException(
    WorkReportErrorCode.WORK_DETAIL_NOT_FOUND
)