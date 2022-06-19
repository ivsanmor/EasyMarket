package net.javaguides.springboot.dto;

import lombok.Data;

/**
 * DTO de cesta 
 * 
 * @author Ivan
 */
@Data
public class CestaDTO {

	/** id de las cestas */
	private Long id;

	/** precio total de las cestas */
	private Double precioTotal;

	/** observaciones de las cestas */
	private String observaciones;

	/** activo de las cestas */
	private boolean activo;
	
	/** usuario al que pertenece la cesta */
	Integer usuarioId;



}
