package com.kodomo.juganbbojjak.global.annotation

import com.kodomo.juganbbojjak.common.annotation.UseCase
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType


@Configuration
@ComponentScan(
    basePackages = ["com.kodomo.juganbbojjak"],
    includeFilters = [
        ComponentScan.Filter(
            type = FilterType.ANNOTATION,
            value = [UseCase::class],
        ),
    ],
)
class ComponentScanConfig