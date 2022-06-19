package net.javaguides.springboot.security.dto;


import lombok.NonNull;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginUsuario.
 */
public class LoginUsuario {
	
	
	/** The nombre usuario. */
	@NonNull
	private String nombreUsuario;
	
	/** The password. */
	@NonNull
	private String password;

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
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
