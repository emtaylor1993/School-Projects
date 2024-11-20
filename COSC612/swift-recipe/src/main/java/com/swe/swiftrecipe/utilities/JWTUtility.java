/**
 * SWIFTRECIPE JWT UTILITY CLASS
 *
 * @author Emmanuel Taylor
 * 
 * @description
 *    This class contains functionality to create, validate, and parse
 *    JSON Web Tokens (JWT).
 * 
 * @packages
 *    Java Security (Key)
 *    Java Utilities (Date, Function)
 *    JSON Web Token IO (Claims, Jwts, SignatureAlgorithm, Keys)
 *    Spring Framework Stereotype (Component)
 */

package com.swe.swiftrecipe.utilities;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTUtility {
    private final String SECRET_KEY = System.getenv("JWT_SECRET_KEY");
    private final long EXPIRATION_TIME = 86400000;
    private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(String username) {
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();
    }

    public boolean validateToken(String token, String username) {
        return extractUsername(token).equals(username) && !isTokenExpired(token);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
            .getBody();
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
}
