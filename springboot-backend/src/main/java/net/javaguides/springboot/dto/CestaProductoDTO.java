package net.javaguides.springboot.dto;


import lombok.Data;


/**
 * DTO de los productos que hay en cada cesta
 * @author Ivan
 */
@Data
public class CestaProductoDTO {
	
	/** id autoincrementable*/
	private Long id;

	/** la cesta*/
	private Long cesta;

	/** el producto*/
	private Long producto;

	/** cantidad de productos en la cesta*/
	private Integer cantidad;


}
