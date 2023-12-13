package com.kodomo.juganbbojjak.domain.user.presentation

import com.kodomo.juganbbojjak.domain.user.dto.response.QueryLatestWorkResponse
import com.kodomo.juganbbojjak.domain.user.dto.response.QueryWeeklyListResponse
import com.kodomo.juganbbojjak.domain.user.model.WeeklyListType
import com.kodomo.juganbbojjak.domain.user.usecase.QueryLatestWorkUseCase
import com.kodomo.juganbbojjak.domain.user.usecase.QueryWeeklyListUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/main")
@RestController
class UserWebAdapter(
    private val queryWeeklyListUseCase: QueryWeeklyListUseCase,
    private val queryLatestWorkUseCase: QueryLatestWorkUseCase
) {

    @GetMapping
    fun queryWeeklyList(@RequestParam("weekly-list-type") weeklyListType: WeeklyListType): QueryWeeklyListResponse =
        queryWeeklyListUseCase.execute(weeklyListType)

    @GetMapping("/latest_work")
    fun queryLatestWork(): QueryLatestWorkResponse =
        queryLatestWorkUseCase.execute()

}