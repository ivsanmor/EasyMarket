package net.javaguides.springboot.dto;


import lombok.Data;

/**
 * DTO de usuario
 * 
 * @author Ivan
 */
@Data
public class UsuarioDTO {
	
	/** id de los usuario */
	private Integer id;
	
	/** nombre de los usuario */
	private String nombre;
	
	/** nombre del usuario de los usuario */
	private String nombreUsuario;
	
	/** email de los usuario */
	private String email;
	
	/** password de los usuario */
	private String password;
	
	/** activo de los usuario */
	private boolean activo;
}
