package net.javaguides.springboot.dto;

import lombok.Data;
import lombok.ToString;

/**
 * DTO de producto
 * 
 * @author Ivan
 */
@Data
@ToString
public class ProductoDTO {

	/** id de los productos */
	private Long id;

	/**nombre del producto */
	private String nombre;

	/**cantidad del producto */
	private Integer cantidad;

	/**precio del producto */
	private Double precio;

	/**descripcion del producto */
	private String descripcion;

	/**imagen del producto */
	private String imagen;

	/**activo del producto */
	private boolean activo;
	
	/**boolean de carro */
	private boolean carro;
	
	/**nombre categoria del producto */
	private String nombreCategoria;
	
	/**oferta del producto */
	private Long idOferta;
	



}
