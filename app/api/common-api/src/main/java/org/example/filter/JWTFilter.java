package org.example.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.security.dto.AuthenticatedInfo;
import org.example.security.dto.UserParam;
import org.example.security.token.JWTHandler;
import org.example.security.token.TokenProcessor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@RequiredArgsConstructor
@Component
public class JWTFilter extends OncePerRequestFilter {

    private final JWTHandler jwtHandler;
    private final TokenProcessor tokenProcessor;

    @Override
    protected void doFilterInternal(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain filterChain
    ) throws ServletException, IOException {
        if (request.getHeader("Authorization") != null) {
            handleAccessToken(request);
        }

        if (request.getHeader("Refresh") != null) {
            handleRefreshToken(request);
        }

        filterChain.doFilter(request, response);
    }

    private void handleAccessToken(HttpServletRequest request) {
        String accessToken = jwtHandler.extractAccessToken(request);
        UserParam userParam = jwtHandler.extractUserFrom(accessToken);
        tokenProcessor.verifyAccessTokenBlacklist(userParam, accessToken);
        saveOnSecurityContextHolder(userParam, accessToken);
    }

    private void saveOnSecurityContextHolder(UserParam userParam, String accessToken) {
        var authenticatedUser = AuthenticatedInfo.getUserWithAccessToken(userParam, accessToken);

        SecurityContextHolder.getContext().setAuthentication(
            new UsernamePasswordAuthenticationToken(
                authenticatedUser,
                null,
                List.of(new SimpleGrantedAuthority(authenticatedUser.role().getAuthority()))
            )
        );
    }

    private void handleRefreshToken(HttpServletRequest request) {
        String refreshToken = jwtHandler.extractRefreshToken(request);
        UserParam userParam = jwtHandler.extractUserFrom(refreshToken);
        saveOnSecurityContextHolderWithRefreshToken(userParam, refreshToken);
    }

    private void saveOnSecurityContextHolderWithRefreshToken(UserParam userParam, String refreshToken) {
        var authenticatedUser = AuthenticatedInfo.getUserWithRefreshToken(userParam, refreshToken);

        SecurityContextHolder.getContext().setAuthentication(
            new UsernamePasswordAuthenticationToken(
                authenticatedUser,
                null,
                List.of(new SimpleGrantedAuthority(authenticatedUser.role().getAuthority()))
            )
        );
    }
}
