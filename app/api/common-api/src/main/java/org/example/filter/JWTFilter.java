package org.example.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.exception.BusinessException;
import org.example.repository.TokenRepository;
import org.example.security.dto.AuthenticatedUser;
import org.example.security.dto.TokenParam;
import org.example.security.dto.UserParam;
import org.example.security.error.TokenError;
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
    private final TokenRepository tokenRepository;

    @Override
    protected void doFilterInternal(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain filterChain
    ) throws ServletException, IOException {
        if (request.getHeader("Refresh") != null) {
            TokenParam token = tokenProcessor.reissueToken(request);
            response.getWriter().write(new ObjectMapper().writeValueAsString(token));
            return;
        }

        if (request.getHeader("Authorization") != null) {
            handleAccessToken(request);
        }

        filterChain.doFilter(request, response);
    }

    private void handleAccessToken(HttpServletRequest request) {
        String accessToken = jwtHandler.extractAccessToken(request);
        UserParam userParam = jwtHandler.extractUserFrom(accessToken);
        verifyAccessTokenBlacklist(userParam, accessToken);
        saveOnSecurityContextHolder(userParam);
    }

    private void verifyAccessTokenBlacklist(UserParam userParam, String accessKey) {
        if (tokenRepository.existAccessToken(userParam.userId(), accessKey)) {
            throw new BusinessException(TokenError.BLACKLIST_ACCESS_TOKEN);
        }
    }

    private void saveOnSecurityContextHolder(UserParam userParam) {
        AuthenticatedUser authenticatedUser = AuthenticatedUser.builder()
            .userId(userParam.userId())
            .role(userParam.role())
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
