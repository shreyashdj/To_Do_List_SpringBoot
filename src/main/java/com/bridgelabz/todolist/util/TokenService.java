package com.bridgelabz.todolist.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.auth0.jwt.interfaces.Verification;
import com.bridgelabz.todolist.exception.CustomException;
import org.springframework.stereotype.Component;

/**
 * @author - Shreyash Jadhav
 */

@Component
public class TokenService {
    private static final String TOKEN_SECRET = "Shreyash3439";

    public String createToken(int id) {
        try {
            //to set algorithm
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);

            return JWT.create().withClaim("user_id", id).sign(algorithm);
        } catch (JWTCreationException exception) {
            exception.printStackTrace();
            //log Token Signing Failed
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int decodeToken(String token) {
        int userid;
        //for verification algorithm
        Verification verification = null;
        try {
            verification = JWT.require(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        assert verification != null;
        JWTVerifier jwtverifier = verification.build();
        //to decode token
        DecodedJWT decodedjwt;
        try {
            decodedjwt = jwtverifier.verify(token);
        } catch (Exception e){
            throw new CustomException("Token Invalid");
        }
        Claim claim = decodedjwt.getClaim("user_id");
        userid = claim.asInt();
        return userid;
    }
}