package ch.bbw.jf.backend.security;
import io.jsonwebtoken.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Class: JwtUtil
 *
 * @author Schules
 * @version 19.03.2024
 */
public class JwtUtil {
    private static final String SECRET = "your-secret-key";
    private static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(Date.from(Instant.now().plusMillis(EXPIRATION_TIME)))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }
    public static String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
