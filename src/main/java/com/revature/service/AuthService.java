package com.revature.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.revature.model.Role;
import com.revature.model.User;
import io.javalin.http.ForbiddenResponse;
import io.javalin.http.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;


public class AuthService {
    private static final Algorithm algorithm = Algorithm.HMAC256("secret");
    private static final JWTVerifier verifier = JWT.require(algorithm).withIssuer("auth0").build();
    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    public static String generateToken(User user){
        String token = null;
        try{
            token = JWT.create()
                    .withIssuer("auth0")
                    .sign(algorithm);
        } catch(JWTCreationException e){
            logger.info(e.getMessage());
        }
        return token;
    }

    public static Handler isAuthenticated = context -> {
        try{
            String token = Objects.requireNonNull(context.header("Authorization")).substring(7);
            verifier.verify(token);
        } catch(Exception e){
            throw new ForbiddenResponse();
        }

    };
}
