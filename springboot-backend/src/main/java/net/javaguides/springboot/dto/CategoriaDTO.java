package net.javaguides.springboot.dto;

import java.util.List;

import lombok.Data;

@Data
public class CategoriaDTO {

	private Long id;
	
	private String nombre;

	private List<ProductoDTO> productos;

	private boolean activo;

}
