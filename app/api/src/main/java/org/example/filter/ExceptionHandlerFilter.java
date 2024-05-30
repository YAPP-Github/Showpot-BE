package org.example.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import exception.BusinessException;
import exception.ErrorResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Slf4j
@Component
public class ExceptionHandlerFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain filterChain
    ) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (BusinessException e) {
            String errorId = UUID.randomUUID().toString();
            log.error(errorId, e);

            response.setStatus(e.error.getHttpStatus());
            response.setContentType("application/json; charset=UTF-8");

            response.getWriter().write(
                new ObjectMapper().writeValueAsString(
                    ErrorResponse.businessErrorResponseBuilder()
                        .errorId(errorId)
                        .error(e.error)
                        .build()
                )
            );
        } catch (RuntimeException e) {
            String errorId = UUID.randomUUID().toString();
            log.error(errorId, e);
        }
    }
}
