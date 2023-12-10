package com.kodomo.juganbbojjak.global.security.jwt

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter

class JwtFilter(
    private val jwtTokenParser: JwtTokenParser,
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) {
        jwtTokenParser.resolveToken(request)?.also {
            SecurityContextHolder.getContext().authentication = jwtTokenParser.getAuthentication(it)
        }

        filterChain.doFilter(request, response)
    }
}
