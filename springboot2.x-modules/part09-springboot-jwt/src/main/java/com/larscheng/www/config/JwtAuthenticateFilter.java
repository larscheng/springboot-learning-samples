package com.larscheng.www.config;

import io.jsonwebtoken.Jwts;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/***
 * jwt身份认证，认证通过后生成token
 */
@Log4j2
public class JwtAuthenticateFilter extends UsernamePasswordAuthenticationFilter {
    private final static String key = "xdY3TXUb4W9tlSc57tWf1s0j7JwWAskiKv49kQsoCpY=";
    private final AuthenticationManager authenticationManager;


    public JwtAuthenticateFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        setFilterProcessesUrl("/api/token");
    }

    /******用户认证******/
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password);

        return this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
    }

    /****认证成功生成token，返回*****/
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        User user = (User) authResult.getPrincipal();
        List<String> roles = user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        SecretKey key = KeyGenerator.getKey();
        String privateKey = Base64.getEncoder().encodeToString(key.getEncoded());
        log.info("key is : {}",privateKey);
        String token = Jwts.builder()
                .setHeaderParam("type", "test")
                .setSubject(user.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + 100000))
                .setAudience("test")
                .setIssuer(user.getUsername())
                .claim("roles",roles)
                .signWith(key).compact();

        response.setHeader("Authorization",token);

    }
}
