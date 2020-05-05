package com.larscheng.www.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * jwt授权验证，判断客户端token信息是否合法
 */
@Log4j2
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, AuthenticationEntryPoint authenticationEntryPoint) {
        super(authenticationManager, authenticationEntryPoint);
    }

    /****校验token，本次请求是否授权通过****/
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        UsernamePasswordAuthenticationToken authorization = getAuthorization(request);
        if (authorization != null) {
            SecurityContextHolder.getContext().setAuthentication(authorization);
        }
        chain.doFilter(request, response);
    }


    public UsernamePasswordAuthenticationToken getAuthorization(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        try {
            if (!StringUtils.isEmpty(token)) {
                Jws<Claims> claimsJws = Jwts.parserBuilder()
                        .setSigningKey(KeyGenerator.getKey())
                        .build()
                        .parseClaimsJws(token);
                String username = claimsJws.getBody().getSubject();
                List<SimpleGrantedAuthority> roles = ((List<?>) claimsJws.getBody().get("roles")).stream()
                        .map(a -> new SimpleGrantedAuthority((String) a))
                        .collect(Collectors.toList());
                if (!username.isEmpty()) {
                    //返回授权结果
                    return new UsernamePasswordAuthenticationToken(username, null, roles);
                }
            }
        } catch (Exception e) {
            log.error("token 不合法, {}", e.getMessage());
        }
        return null;
    }
}
