package com.kodomo.juganbbojjak.global.security

import com.fasterxml.jackson.databind.ObjectMapper
import com.kodomo.juganbbojjak.domain.user.model.Authority.USER
import com.kodomo.juganbbojjak.domain.user.model.Authority.ADMIN
import com.kodomo.juganbbojjak.global.security.jwt.JwtTokenParser
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
@Configuration
class SecurityConfig(
    private val jwtTokenParser: JwtTokenParser,
    private val objectMapper: ObjectMapper,
) {

    @Bean
    protected fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .formLogin { it.disable() }
            .csrf { it.disable() }
            .cors {}
            .sessionManagement {
                it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            }
            .authorizeHttpRequests {
                it
                    .requestMatchers(HttpMethod.POST, "/event_schedules/{weekly-event-schedule-id}").hasAuthority(USER.name)
                    .anyRequest().permitAll()
            }
            .apply(FilterConfig(jwtTokenParser, objectMapper))

        return http.build()
    }

    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder()
}
