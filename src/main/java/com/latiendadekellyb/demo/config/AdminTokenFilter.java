package com.latiendadekellyb.demo.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class AdminTokenFilter extends OncePerRequestFilter {

    private static final String ADMIN_TOKEN_HEADER = "X-Admin-Token";
    private static final Set<String> READ_ONLY_METHODS = Set.of("GET", "HEAD", "OPTIONS");
    private static final List<String> PROTECTED_PREFIXES = List.of("/api/products", "/api/landing");

    private final String adminToken;

    public AdminTokenFilter(@Value("${app.security.admin-token:}") String adminToken) {
        this.adminToken = adminToken == null ? "" : adminToken.trim();
    }

    @Override
    protected void doFilterInternal(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain filterChain
    ) throws ServletException, IOException {
        String path = request.getRequestURI();
        String method = request.getMethod();

        if (!isProtectedPath(path) || READ_ONLY_METHODS.contains(method)) {
            filterChain.doFilter(request, response);
            return;
        }

        if (adminToken.isBlank()) {
            writeJsonError(response, HttpStatus.SERVICE_UNAVAILABLE, "Admin writes are disabled on this backend");
            return;
        }

        String providedToken = request.getHeader(ADMIN_TOKEN_HEADER);
        if (!adminToken.equals(providedToken)) {
            writeJsonError(response, HttpStatus.UNAUTHORIZED, "Admin token is missing or invalid");
            return;
        }

        filterChain.doFilter(request, response);
    }

    private boolean isProtectedPath(String path) {
        for (String prefix : PROTECTED_PREFIXES) {
            if (path.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }

    private void writeJsonError(HttpServletResponse response, HttpStatus status, String message) throws IOException {
        response.setStatus(status.value());
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String body = String.format(
            "{\"timestamp\":\"%s\",\"status\":%d,\"error\":\"%s\"}",
            LocalDateTime.now(),
            status.value(),
            message.replace("\"", "")
        );
        response.getWriter().write(body);
    }
}
