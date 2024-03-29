package com.notesApp.util;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.notesApp.model.UserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class JwtUtil {
    private final String secret_key = "mysecretkey";
    private long accessTokenValidity = 60*60*1000;
    
    private final JwtParser jwtParser;
    
    private final String TOKEN_HEADER = "Authorization";
    private final String TOKEN_PREFIX = "Bearer ";
    
    public JwtUtil() {
    	this.jwtParser = Jwts.parser().setSigningKey(secret_key);
    }
    
    public String createToken(UserDetails user) {
    	Claims claims = Jwts.claims().setSubject(user.getUsername());
    	claims.put("id", user.getId());
    	Date tokenCreationTime = new Date();
    	Date tokenValidity = new Date(tokenCreationTime.getTime() + TimeUnit.MINUTES.toMillis(accessTokenValidity));
    	return Jwts.builder()
    			.setClaims(claims)
    			.setExpiration(tokenValidity)
    			.signWith(SignatureAlgorithm.HS256, secret_key)
    			.compact();
    }
    
    private Claims parseJwtClaims(String token) {
    	return jwtParser.parseClaimsJws(token).getBody();
    }
    
    public Claims resolveClaims(HttpServletRequest request) {
        try {
            String token = resolveToken(request);
            if (token != null) {
                return parseJwtClaims(token);
            }
            return null;
        } catch (ExpiredJwtException ex) {
            request.setAttribute("expired", ex.getMessage());
            throw ex;
        } catch (Exception ex) {
            request.setAttribute("invalid", ex.getMessage());
            throw ex;
        }
    	
    }
    
    public String resolveToken(HttpServletRequest request) {

        String bearerToken = request.getHeader(TOKEN_HEADER);
        if (bearerToken != null && bearerToken.startsWith(TOKEN_PREFIX)) {
            return bearerToken.substring(TOKEN_PREFIX.length());
        }
        return null;
    }
    
    public boolean validateClaims(Claims claims) throws AuthenticationException {
        try {
            return claims.getExpiration().after(new Date());
        } catch (Exception e) {
            throw e;
        }
    }
    
    public String getUsername(Claims claims) {
    	return claims.getSubject();
    }
    
    @SuppressWarnings({ "unchecked", "unused" })
	private List<String> getRoles(Claims claims) {
        return (List<String>) claims.get("roles");
    }

}
