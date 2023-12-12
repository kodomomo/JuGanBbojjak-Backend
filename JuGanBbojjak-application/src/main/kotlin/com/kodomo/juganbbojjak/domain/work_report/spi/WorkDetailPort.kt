package com.kodomo.juganbbojjak.domain.work_report.spi

import com.kodomo.juganbbojjak.domain.work_report.model.WorkDetail
import java.util.UUID

interface WorkDetailPort : CommandWorkDetailPort, QueryWorkDetailPort

interface CommandWorkDetailPort{
    fun saveAllWorkDetails(workDetails: List<WorkDetail>)
}

interface QueryWorkDetailPort{
    fun queryWorkDetailByWorkReportId(workReportId: UUID): List<WorkDetail>
}