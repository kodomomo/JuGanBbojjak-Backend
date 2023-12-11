package com.kodomo.juganbbojjak.domain.work_report.persistence

import com.kodomo.juganbbojjak.domain.work_report.model.WorkDetail
import com.kodomo.juganbbojjak.domain.work_report.persistence.mapper.WorkDetailMapper
import com.kodomo.juganbbojjak.domain.work_report.persistence.repository.WorkDetailRepository
import com.kodomo.juganbbojjak.domain.work_report.spi.WorkDetailPort
import com.kodomo.juganbbojjak.global.annotation.Adapter

@Adapter
class WorkDetailPersistenceAdapter(
    private val workDetailRepository: WorkDetailRepository,
    private val workDetailMapper: WorkDetailMapper
) : WorkDetailPort {

    override fun saveAllWorkDetails(workDetails: List<WorkDetail>) {
        workDetailRepository.saveAll(
            workDetails.map { workDetailMapper.toEntity(it) }
        )
    }
}