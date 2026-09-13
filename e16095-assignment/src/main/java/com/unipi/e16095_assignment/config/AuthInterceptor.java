package com.unipi.e16095_assignment.config;

import com.unipi.e16095_assignment.enums.RoleEnum;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    private static final String ROLE_ADMIN = RoleEnum.ADMIN.name();
    private static final String ROLE_TECHNICIAN = RoleEnum.TECHNICIAN.name();
    private static final String ROLE_USER = RoleEnum.USER.name();
    private static final String ROLE_NOT_ASSIGNED = RoleEnum.NOT_ASSIGNED.name();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 1. Disable browser caching for all protected routes
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0
        response.setDateHeader("Expires", 0); // Proxies

        // 2. Check for active session
        HttpSession session = request.getSession(false);
        boolean isLoggedIn = (session != null && session.getAttribute("loggedInUser") != null);

        // 3. Unauthenticated check
        if (!isLoggedIn) {
            response.sendRedirect("/api/login");
            return false;
        }

        // 3. Admin authorization check
        String requestURI = request.getRequestURI();
        String role = (String) session.getAttribute("userRole");
        if (requestURI.startsWith("/api/level-user")) {
            // If user is a NOT_ASSIGNED or has NO role at all, block access and redirect
            if (role == null || role.isBlank() || role.equalsIgnoreCase(ROLE_NOT_ASSIGNED)) {
                response.sendRedirect("/api/accessDenied");

                return false;
            }
        } else if (requestURI.startsWith("/api/level-tech")) {
            // If user is not an TECHNICIAN or ADMIN, block access and redirect
            if (role == null || role.isBlank() || (!role.equalsIgnoreCase(ROLE_TECHNICIAN) && !role.equalsIgnoreCase(ROLE_ADMIN))) {
                response.sendRedirect("/api/accessDenied");

                return false;
            }
        } else if (requestURI.startsWith("/api/level-admin")) {
            // If user is not an ADMIN, block access and redirect
            if (role == null || role.isBlank() || !role.equalsIgnoreCase(ROLE_ADMIN)) {
                response.sendRedirect("/api/accessDenied");

                return false;
            }
        }

        return true;
    }
}