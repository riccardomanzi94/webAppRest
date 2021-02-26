package it.riccardo.app.webapprest.config.security;

import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;

public class AuthorizationFilter extends BasicAuthenticationFilter {

    private JwtProvider jwtProvider;
    private String prefix;
    private String param;

    @Autowired
    public AuthorizationFilter(AuthenticationManager authenticationManager, JwtProvider jwtProvider, String prefix, String param) {
        super(authenticationManager);
        this.jwtProvider = jwtProvider;
        this.prefix = prefix;
        this.param = param;
    }

    @SneakyThrows
    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain){
        String header = req.getHeader(param);
        if (header == null || !header.startsWith(prefix)) {
            chain.doFilter(req, res);
            return;
        }
        UsernamePasswordAuthenticationToken authentication = this.getAuthentication(header);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String header) {
        DecodedJWT decoded = jwtProvider.decodeJwt(header);
        return new UsernamePasswordAuthenticationToken(decoded.getSubject(), null, Collections.emptyList());
    }
}
