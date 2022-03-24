package com.example.fm6app.common;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.fm6app.Fm6AppApplication;
import com.example.fm6app.domain.UserAdherent;
import com.example.fm6app.service.facade.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    @Value("${jwt.expiration}")
    private long EXPIRATION;
    @Value("${jwt.secret")
    private String SECRET;
    @Value("${jwt.header.name}")
    private String JWT_HEADER_NAME;
    @Value("${jwt.header.prefix}")
    private String HEADER_PREFIX;

    @Autowired
    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            UserAdherent myUser = new ObjectMapper().readValue(request.getInputStream(), UserAdherent.class);
            System.out.println(myUser.getUsername());
            System.out.println(myUser.getPassword());
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(myUser.getUsername(),myUser.getPassword()));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException, ServletException {
        UserAdherent user = (UserAdherent) authResult.getPrincipal();

        UserService userService = Fm6AppApplication.getCtx().getBean(UserService.class);

        UserAdherent myUser = userService.findByUsernameWithRoles(user.getUsername());

        Collection<String> roles = new ArrayList<>();
        if (myUser.getAuthorities() != null) {
            myUser.getAuthorities().forEach(a->roles.add(a.getAuthority()));
        }
        Boolean passwordChanged = myUser.isPasswordChanged();
        if (passwordChanged == null) {
            passwordChanged=Boolean.FALSE;
        }

        String jwt= JWT.create()
                .withIssuer(request.getRequestURI())
                .withSubject(user.getUsername())
                .withSubject(user.getFirstName())
                .withSubject(user.getLastName())
                .withArrayClaim("roles",roles.toArray(new String[roles.size()]))
                .withExpiresAt(new Date(System.currentTimeMillis()+ EXPIRATION))
                .withClaim("passwordChanged",passwordChanged)
                .sign(Algorithm.HMAC256(SECRET));
        response.addHeader(JWT_HEADER_NAME,HEADER_PREFIX+jwt);
        System.out.println(jwt);
    }

}
