package net.javaguides.springboot.dto;


import lombok.Data;

@Data
public class CestaProductoDTO {
	
	private Long id;

	private String cestaId;

	private ProductoDTO producto;

	private Integer cantidad;


}
