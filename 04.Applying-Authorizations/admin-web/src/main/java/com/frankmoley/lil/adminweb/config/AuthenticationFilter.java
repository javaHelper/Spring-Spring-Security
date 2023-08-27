package com.frankmoley.lil.adminweb.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
@Slf4j
public class AuthenticationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        SecurityContextImpl sci = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
        if (sci != null) {
            UserDetails userDetails = (UserDetails) sci.getAuthentication().getPrincipal();
            log.info("Username {}, Password {}, Authorities {}", userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
        }
        filterChain.doFilter(request, response);
    }
}