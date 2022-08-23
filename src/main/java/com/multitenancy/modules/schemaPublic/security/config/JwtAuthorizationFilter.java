package com.multitenancy.modules.schemaPublic.security.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.multitenancy.modules.schemaPublic.multitenancy.entity.TenantContext;
import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@AllArgsConstructor
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        request.setAttribute("Authorization", "");
        String authorization = request.getHeader("Authorization");
        if (authorization != null && authorization.startsWith("Bearer ")) {
            Claims claims = jwtUtil.getClaims(authorization.replace("Bearer ", ""));
            String schema = claims.get("schema").toString();
            UsernamePasswordAuthenticationToken authentication = getAuthentication(authorization);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            TenantContext.setCurrentTenant(schema.toLowerCase());
        }
        filterChain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String authorization) throws JsonProcessingException {
        String token = authorization.substring(7);
        if (jwtUtil.isTokenValid(token)) {
            var username = jwtUtil.getUsername(token);
            return new UsernamePasswordAuthenticationToken(username, null, null);
        }
        throw new UsernameNotFoundException("Token Invalid");
    }
}
