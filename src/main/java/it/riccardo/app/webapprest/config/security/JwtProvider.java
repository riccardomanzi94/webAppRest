package it.riccardo.app.webapprest.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JwtProvider {

    @Value("${security.secret}")
    private String secret;

    @Value("${security.prefix}")
    private String prefix;

    public String createJwt(){
        return JWT.create()
                .withSubject("subject")
                .withIssuer("issuer")
                .withIssuedAt(DateTime.now().toDate())
                .withClaim("someClaim", "someClaimDesc")
                .withExpiresAt(DateTime.now().plusMonths(1).toDate())
                .sign(Algorithm.HMAC256(secret));
    }

    public DecodedJWT decodeJwt(String jwt) {
        try {
            jwt = jwt.replace(prefix, "").trim();
            return JWT.require(Algorithm.HMAC256(secret)).build().verify(jwt);
        } catch (Exception e) {
            log.error("Invalid JWT", e);
        }
        return null;
    }
}
