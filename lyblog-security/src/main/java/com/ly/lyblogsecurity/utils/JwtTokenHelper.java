package com.ly.lyblogsecurity.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Date;

/**
 * @Author: dly
 * @Date: 2025-07-10-0:20
 * @Description:
 */
@Component
public class JwtTokenHelper implements InitializingBean {

    /**
     * 签发人
     */
    @Value("${jwt.issuer}")
    private String issuer;

    /**
     * 密钥
     */
    private Key key;

    /**
     * JWT 解析器
     */
    private JwtParser jwtParser;

    /**
     * 解码配置文件中配置的 Base 64 编码 key 为秘钥
     * @param base64Key
     */
    @Value("${jwt.secret}")
    public void setBase64Key(String base64Key) {
        key = Keys.hmacShaKeyFor(Base64.getDecoder().decode(base64Key));
    }

    /**
     * 初始化 JwtParser
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        // JJWT 0.12.x 新版写法：Jwts.parser() 返回 JwtParserBuilder
        // 考虑到不同服务器之间可能存在时钟偏移，setAllowedClockSkewSeconds 用于设置能够容忍的最大的时钟误差
        jwtParser = Jwts.parser()
                .requireIssuer(issuer)
                .verifyWith((SecretKey) key)
                .clockSkewSeconds(10)
                .build();
    }

    /**
     * 生成 Token
     * @param username
     * @return
     */
    public String generateToken(String username) {
        LocalDateTime now = LocalDateTime.now();
        // token一小时过期
        LocalDateTime expireTime = now.plusHours(1);

        return Jwts.builder()
                .subject(username)
                .issuer(issuer)
                .issuedAt(Date.from(now.atZone(ZoneId.systemDefault()).toInstant()))
                .expiration(Date.from(expireTime.atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(key)
                .compact();
    }

    /**
     * 解析 Token
     * @param token
     * @return
     */
    public Jws<Claims> parseToken(String token) {
        try {
            return jwtParser.parseSignedClaims(token);
        } catch (SecurityException | MalformedJwtException | IllegalArgumentException | UnsupportedJwtException e) {
            throw new BadCredentialsException("Token 无效", e);
        } catch (ExpiredJwtException e) {
            throw new CredentialsExpiredException("Token 已过期", e);
        }
    }

    /**
     * 生成一个 Base64 的安全秘钥
     * @return
     */
    public static String generateBase64Key() {
        // 生成一个 Base64 的安全秘钥
        Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
        // 将密钥进行 Base64 编码
        String base64Key = Base64.getEncoder().encodeToString(secretKey.getEncoded());

        return base64Key;
    }

    public static void main(String[] args) {
        System.out.println("Base64 Key: " + generateBase64Key());
    }
}

