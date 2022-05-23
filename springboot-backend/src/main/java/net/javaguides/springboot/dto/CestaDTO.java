package net.javaguides.springboot.dto;

import java.util.List;

import lombok.Data;
@Data
public class CestaDTO {

	private Long id;

	private Double precioTotal;

	private String observaciones;

	private boolean cancelar;

	private boolean activo;
	
	String usuarioId;

	private List<CestaProductoDTO> cestaProducto;



}
