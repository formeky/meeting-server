package com.meeting.meeting_server.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.meeting.meeting_server.conf.AppConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.util.Calendar;

/**
 * @author kaka
 */
public class TokenUtil {
    /**
     * 密钥
     */
    private static final String SIGN = "231@$#!$@";


    /**
     * 生成Token
     * @param openid
     * @return
     */
    public static String getToken(String openid){
        JWTCreator.Builder builder = JWT.create();
        builder.withClaim("openid",openid);

        Calendar calendar = Calendar.getInstance();
        //token过期时间,30分钟
        calendar.add(Calendar.MINUTE,30);
        //设置token过期时间,使用秘钥进行加密
        String token = builder.withExpiresAt(calendar.getTime()).sign(Algorithm.HMAC512(SIGN));
        return token;
    }


    /**
     * 验证token
     * @param token
     */
    public static void verifierToken(String token){
        JWT.require(Algorithm.HMAC512(SIGN)).build().verify(token);
    }

    /**
     * 验证OJtoken
     * @param token
     */
    public static void verifierOJToken(String token){
        Claims claims = Jwts.parser().setSigningKey(AppConfig.getSecret_key()).parseClaimsJws(token).getBody();
    }
    /**
     * 验证token
     * @param token
     */
    public static String getMsg(String token){
       return JWT.decode(token).getClaim("openid").asString();
    }
}
