package net.javaguides.springboot.dto;

import lombok.Data;

@Data
public class ProductoOfertaDTO {

	private Long productoID;
	
	private Long ofertaID;
	
	private String nombre;

	private Integer cantidad;

	private Double precioInicial;

	private Double precioFinal;

	private Integer oferta;

	private String descripcion;

	private String imagen;

}
