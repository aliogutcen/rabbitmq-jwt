package com.ali.utility;

import com.ali.exception.BlogMicroServiceException;
import com.ali.exception.ErrorType;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.Optional;

@ControllerAdvice
public class JwtTokenGenerator {

    private final String password = "${PASSWORD}";
    private final Long extraTime = 1000L * 60 * 15;


    public Long decodeToken(String token) {
        Algorithm algorithm = Algorithm.HMAC512(password);
        JWTVerifier verifier = JWT.require(algorithm).withIssuer("Ali").build();
        DecodedJWT decodedJWT = verifier.verify(token);
        if (decodedJWT == null) throw new BlogMicroServiceException(ErrorType.TOKEN_VALID_ERROR);
        return decodedJWT.getClaim("id").asLong();
    }
}
