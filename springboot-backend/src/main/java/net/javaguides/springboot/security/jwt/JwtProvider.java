package net.javaguides.springboot.security.jwt;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import net.javaguides.springboot.security.entity.UsuarioPrincipal;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class JwtProvider.
 */
@Component
public class JwtProvider {
	
	/** The Constant logger. */
	private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

	/** The secret. */
	@Value("${jwt.secret}")
	private String secret;

	/** The expiration. */
	@Value("${jwt.expiration}")
	private int expiration;

	/**
	 * Generate token.
	 *
	 * @param authentication the authentication
	 * @return the string
	 */
	public String generateToken(Authentication authentication) {
		UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
		return Jwts.builder().setSubject(usuarioPrincipal.getUsername()).setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime() + expiration * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	/**
	 * Gets the nombre usuario from token.
	 *
	 * @param token the token
	 * @return the nombre usuario from token
	 */
	public String getNombreUsuarioFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
	}

	/**
	 * Validate token.
	 *
	 * @param token the token
	 * @return true, if successful
	 */
	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
			return true;
		} catch (MalformedJwtException e) {
			logger.error("token mal formado");
		} catch (UnsupportedJwtException e) {
			logger.error("token no soportado");
		} catch (ExpiredJwtException e) {
			logger.error("token expirado");
		} catch (IllegalArgumentException e) {
			logger.error("token vacío");
		} catch (SignatureException e) {
			logger.error("fail en la firma");
		}
		return false;
	}
}