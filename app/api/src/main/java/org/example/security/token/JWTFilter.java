package org.example.security.token;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import exception.BusinessException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.example.security.dto.AuthenticatedUser;
import org.example.security.dto.TokenParam;
import org.example.security.vo.TokenError;
import org.example.vo.UserRoleApiType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@RequiredArgsConstructor
@Component
public class JWTFilter extends OncePerRequestFilter {

    private final JWTProcessor jwtProcessor;
    private final RefreshTokenProcessor refreshTokenProcessor;

    @Override
    protected void doFilterInternal(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain filterChain
    ) throws ServletException, IOException {
        if (request.getHeader("Refresh") != null) {
            TokenParam token = refreshTokenProcessor.process(request, response);
            response.getWriter().write(new ObjectMapper().writeValueAsString(token));
            return;
        }

        if (request.getHeader("Authorization") != null) {
            handleAccessToken(request);
        }

        filterChain.doFilter(request, response);
    }

    private void handleAccessToken(HttpServletRequest request) {
        String accessToken = jwtProcessor.extractAccessToken(request);
        DecodedJWT decodedJWT = jwtProcessor.decodeToken(accessToken);
        saveOnSecurityContextHolder(decodedJWT);
    }

    private void saveOnSecurityContextHolder(DecodedJWT decodedJWT) {
        Map<String, Object> claims = decodedJWT.getClaim("claim").asMap();

        if (!claims.containsKey("userId") || !claims.containsKey("role")) {
            throw new BusinessException(TokenError.INVALID_CLAIM);
        }

        AuthenticatedUser authenticatedUser = AuthenticatedUser.builder()
            .userId(UUID.fromString(claims.get("userId").toString()))
            .role(UserRoleApiType.valueOf(claims.get("role").toString()))
            .build();

        SecurityContextHolder.getContext().setAuthentication(
            new UsernamePasswordAuthenticationToken(
                authenticatedUser,
                null,
                List.of(new SimpleGrantedAuthority(authenticatedUser.role().getAuthority()))
            )
        );
    }
}
