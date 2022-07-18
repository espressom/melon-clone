package com.example.backend;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.Test;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTSimpleTest {

    private void printToken(String token) {
        String[] tokens = token.split("\\.");
        System.out.println("header: " + new String(Base64.getDecoder().decode(tokens[0])));
        System.out.println("payload: " + new String(Base64.getDecoder().decode(tokens[1])));
    }

    @Test
    public void JWT_생성_테스트() {
        HashMap<String, Object> payloadClaims = new HashMap<>();
        String jwt = JWT.create()
                .withPayload(Map.of("name", "YR", "value", 1234))
                .withSubject("user")
                .sign(Algorithm.HMAC256("secret"));
        System.out.println("jwt: " + jwt);
        printToken(jwt);
    }

    @Test
    public void JWT_검증_테스트() {
        String jwt = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiWVIiLCJ2YWx1ZSI6MTIzNH0.rd4yacMqWotOIO1VRJNaOrAh2rCUrY7VlojjrthPg84";
        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256("secret"))
                                  .build()
                                    .verify(jwt);
        decodedJWT.getClaims().forEach((s, claim) -> System.out.println("s: "+s+"\nclaim: "+claim));
    }

    @Test
    public void JWT_만료_시간_테스트() throws InterruptedException {
        final Algorithm ALGORITHM = Algorithm.HMAC256("secret");

        // given
        String jwt = JWT.create()
                .withSubject("user")
                .withExpiresAt(new Date(System.currentTimeMillis() + 3000))
                .sign(ALGORITHM);


        Thread.sleep(5000);

        // when
        try {
            DecodedJWT decodedJWT = JWT.require(ALGORITHM)
                    .build()
                    .verify(jwt);
            System.out.println(decodedJWT.getClaims());
        } catch (TokenExpiredException expiredException) {
            System.out.println("만료된 토큰입니다.");
            DecodedJWT decodedJWT = JWT.decode(jwt);
            System.out.println(decodedJWT.getClaims());
        }

    }

}
