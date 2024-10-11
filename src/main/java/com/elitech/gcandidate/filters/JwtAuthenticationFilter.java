package com.elitech.gcandidate.filters;

import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final String jwtSecretKey;
    private final long jwtExpirationTime;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, String jwtSecretKey, long jwtExpirationTime) {
        this.authenticationManager = authenticationManager;
        this.jwtSecretKey = jwtSecretKey;
        this.jwtExpirationTime = jwtExpirationTime;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);

        return authenticationManager.authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
        
        User user = (User) authResult.getPrincipal();
        Algorithm algorithm = Algorithm.HMAC256(jwtSecretKey.getBytes());

        String token = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + jwtExpirationTime * 1000)) // Expiration time in milliseconds
                .withIssuer(request.getRequestURL().toString())
                .sign(algorithm);

        response.setHeader("Authorization", "Bearer " + token);
    }
}
