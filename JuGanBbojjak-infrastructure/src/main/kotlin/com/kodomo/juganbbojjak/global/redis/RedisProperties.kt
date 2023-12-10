package com.kodomo.juganbbojjak.global.redis

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("redis")
data class RedisProperties(
    val port: Int,
    val host: String,
    val password: String,
)
