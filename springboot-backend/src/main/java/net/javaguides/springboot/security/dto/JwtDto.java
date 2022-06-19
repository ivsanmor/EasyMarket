package net.javaguides.springboot.security.dto;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

// TODO: Auto-generated Javadoc
/**
 * The Class JwtDto.
 */
public class JwtDto {
	
	/** The token. */
	private String token;
	
	/** The bearer. */
	private String bearer = "Bearer";
	
	/** The nombre usuario. */
	private String nombreUsuario;
	
	/** The authorities. */
	private Collection<? extends GrantedAuthority> authorities;

	/**
	 * Instantiates a new jwt dto.
	 *
	 * @param token the token
	 * @param nombreUsuario the nombre usuario
	 * @param authorities the authorities
	 */
	public JwtDto(String token, String nombreUsuario, Collection<? extends GrantedAuthority> authorities) {
		this.token = token;
		this.nombreUsuario = nombreUsuario;
		this.authorities = authorities;
	}

	/**
	 * Gets the token.
	 *
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * Sets the token.
	 *
	 * @param token the new token
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * Gets the bearer.
	 *
	 * @return the bearer
	 */
	public String getBearer() {
		return bearer;
	}

	/**
	 * Sets the bearer.
	 *
	 * @param bearer the new bearer
	 */
	public void setBearer(String bearer) {
		this.bearer = bearer;
	}

	/**
	 * Gets the nombre usuario.
	 *
	 * @return the nombre usuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * Sets the nombre usuario.
	 *
	 * @param nombreUsuario the new nombre usuario
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * Gets the authorities.
	 *
	 * @return the authorities
	 */
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	/**
	 * Sets the authorities.
	 *
	 * @param authorities the new authorities
	 */
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
}