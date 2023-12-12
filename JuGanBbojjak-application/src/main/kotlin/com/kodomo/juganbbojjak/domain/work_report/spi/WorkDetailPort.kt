package com.kodomo.juganbbojjak.domain.work_report.spi

import com.kodomo.juganbbojjak.domain.work_report.model.WorkDetail

interface WorkDetailPort : CommandWorkDetail

interface CommandWorkDetail{
    fun saveAllWorkDetails(workDetails: List<WorkDetail>)
}
