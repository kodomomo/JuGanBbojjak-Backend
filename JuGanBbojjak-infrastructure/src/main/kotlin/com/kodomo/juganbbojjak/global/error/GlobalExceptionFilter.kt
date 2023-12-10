package com.kodomo.juganbbojjak.global.error

import com.fasterxml.jackson.databind.ObjectMapper
import com.kodomo.juganbbojjak.common.error.ErrorProperty
import com.kodomo.juganbbojjak.common.error.JuGanBbojjakException
import com.kodomo.juganbbojjak.global.error.response.ErrorResponse
import com.kodomo.juganbbojjak.global.exception.InternalServerErrorException
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import java.nio.charset.StandardCharsets

class GlobalExceptionFilter(
    private val objectMapper: ObjectMapper,
): OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: Exception) {
            when(e.cause) {
                is JuGanBbojjakException -> writeErrorResponse(response, (e.cause as JuGanBbojjakException).errorProperty)
                else -> {
                    e.printStackTrace()
                    writeErrorResponse(response, InternalServerErrorException.errorProperty)
                }
            }
        }
    }

    private fun writeErrorResponse(response: HttpServletResponse, errorProperty: ErrorProperty) {
        val errorResponse = ErrorResponse(errorProperty.status, errorProperty.message)
        response.apply {
            status = errorProperty.status
            contentType = MediaType.APPLICATION_JSON_VALUE
            characterEncoding = StandardCharsets.UTF_8.name()
            writer.write(objectMapper.writeValueAsString(errorResponse))
        }
    }
}