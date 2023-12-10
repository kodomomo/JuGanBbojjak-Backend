package com.kodomo.juganbbojjak.global.security.jwt

import com.kodomo.juganbbojjak.global.exception.ExpiredTokenException
import com.kodomo.juganbbojjak.global.exception.InvalidTokenException
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import jakarta.servlet.http.HttpServletRequest
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component
class JwtTokenParser(
    private val userDetailsService: UserDetailsService,
    private val jwtProperties: JwtProperties,
) {

    companion object {
        const val JWT_HEADER = "Authorization"
        const val JWT_PREFIX = "Bearer "
    }

    fun getAuthentication(token: String): Authentication {
        val claims = getClaims(token)

        if (claims["type"] != TokenType.ACCESS.name) {
            throw InvalidTokenException
        }

        val userDetails = userDetailsService.loadUserByUsername(claims.subject)
        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
    }

    fun resolveToken(request: HttpServletRequest): String? {
        val token = request.getHeader(JWT_HEADER)
        if (token != null && token.startsWith(JWT_PREFIX)) {
            return token.replace(JWT_PREFIX, "")
        }
        return null
    }

    private fun getClaims(token: String): Claims {
        try {
            return Jwts.parser()
                .setSigningKey(jwtProperties.secret)
                .parseClaimsJws(token).body
        } catch (e: ExpiredJwtException) {
            throw ExpiredTokenException
        } catch (e: Exception) {
            throw InvalidTokenException
        }
    }
}
