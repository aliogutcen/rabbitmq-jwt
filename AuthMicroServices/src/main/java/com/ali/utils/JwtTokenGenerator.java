package com.ali.utils;

import com.ali.exception.AuthMicroServiceException;
import com.ali.exception.ErrorType;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.web.bind.annotation.ControllerAdvice;
import java.util.Date;
import java.util.Optional;

@ControllerAdvice
public class JwtTokenGenerator {

    private final String password = "${PASSWORD}";
    private final Long extraTime = 1000L * 60 * 15;

    public Optional<String> createToken(Long id) {

            String token = "";
            token = JWT.create().withAudience()
                    .withClaim("id", id)
                    .withIssuer("Ali")
                    .withIssuedAt(new Date())
                    .withExpiresAt(new Date(System.currentTimeMillis() + extraTime))
                    .sign(Algorithm.HMAC512(password));
            if (token == null) throw new AuthMicroServiceException(ErrorType.TOKEN_ERROR);
            return Optional.of(token);
    }
    public Optional<Long> decodeToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC512(password);
            JWTVerifier verifier = JWT.require(algorithm).withIssuer("Ali").build();
            DecodedJWT decodedJWT = verifier.verify(token);
            if (decodedJWT == null) throw new AuthMicroServiceException(ErrorType.TOKEN_VALID_ERROR);
            return Optional.of(decodedJWT.getClaim("id").asLong());
        } catch (Exception exception) {
            throw new AuthMicroServiceException(ErrorType.TOKEN_VALID_ERROR);
        }
    }
}
