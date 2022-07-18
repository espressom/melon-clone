package com.example.backend.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.backend.domain.users.User;

import java.time.Instant;
import java.util.Map;

public class JWTUtil {

    private static final Algorithm ALGORITHM = Algorithm.HMAC256("melon-clone");
    private static final long AUTH_TIME = 60*10; // 10분
    private static final long REFRESH_TIME = 60*60*24*7; // 일주일

    public static String makeAuthToken(User user) {
        return JWT.create()
                .withSubject(user.getEmail())
                .withPayload(Map.of("userId", user.getId()))
                .withExpiresAt(Instant.ofEpochSecond(Instant.now().getEpochSecond()+AUTH_TIME))
                .sign(ALGORITHM);
    }

    public static String makeRefreshToken(User user) {
        return JWT.create()
                .withSubject(user.getEmail())
                .withExpiresAt(Instant.ofEpochSecond(Instant.now().getEpochSecond()+REFRESH_TIME))
                .sign(ALGORITHM);
    }

    public static VerifyResult verify(String jwt) {

        try {
            DecodedJWT decodedJWT = JWT.require(ALGORITHM).build().verify(jwt);
            return VerifyResult.builder()
                    .success(true)
                    .userEmail(decodedJWT.getSubject())
                    .userId(decodedJWT.getClaim("userId").asLong())
                    .build();

        } catch (Exception ex) {
            DecodedJWT decodedJWT = JWT.decode(jwt);
            return VerifyResult.builder()
                    .success(false)
                    .userEmail(decodedJWT.getSubject())
                    .userId(decodedJWT.getClaim("userId").asLong())
                    .build();

        }

    }

}
