package org.example.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.example.exception.BusinessException;
import org.example.exception.ErrorResponse;
import org.example.exception.GlobalError;
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
            ErrorResponse responseBody = ErrorResponse.businessErrorResponseBuilder()
                .errorId(errorId)
                .error(e.error)
                .build();

            log.error(errorId, e);

            response.setStatus(e.error.getHttpStatus());
            response.setContentType("application/json; charset=UTF-8");

            response.getWriter().write(
                new ObjectMapper().writeValueAsString(
                    responseBody
                )
            );
        } catch (RuntimeException e) {
            String errorId = UUID.randomUUID().toString();
            ErrorResponse responseBody = ErrorResponse.businessErrorResponseBuilder()
                .errorId(errorId)
                .error(GlobalError.INTERNAL_SERVER_ERROR)
                .build();

            log.error(errorId, e);

            response.setStatus(500);
            response.setContentType("application/json; charset=UTF-8");

            response.getWriter().write(
                new ObjectMapper().writeValueAsString(responseBody)
            );
        }
    }
}
