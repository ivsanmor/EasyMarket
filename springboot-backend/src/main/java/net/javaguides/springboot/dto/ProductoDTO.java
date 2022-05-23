package net.javaguides.springboot.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProductoDTO {

	private Long id;

	private String nombre;

	private Integer cantidad;

	private Double precio;

	private String descripcion;

	private String imagen;

	private boolean activo;
	
	private Long idCategoria;

	private Long idOferta;
	



}
