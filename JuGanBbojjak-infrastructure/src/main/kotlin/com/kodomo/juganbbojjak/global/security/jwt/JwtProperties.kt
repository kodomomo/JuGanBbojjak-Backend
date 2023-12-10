package com.kodomo.juganbbojjak.global.security.jwt

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("jwt")
class JwtProperties(
    val secret: String,
    val accessExp: Int,
    val refreshExp: Int,
)