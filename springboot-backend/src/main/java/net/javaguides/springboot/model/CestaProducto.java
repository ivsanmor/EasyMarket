package net.javaguides.springboot.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

/**
 * Entidad de los productos que hay en cada cesta
 * @author Ivan
 */
@Data
@Entity
@Table(name = "cesta_producto")
public class CestaProducto {

	/** id autoincrementable*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** la cesta*/
	@JoinColumn(name = "cesta_id")
	private Long cesta;

	/** el producto*/
	@JoinColumn(name = "producto_id")
	private Long producto;

	/** cantidad de productos en la cesta*/
	@Column(name = "cantidad")
	private Integer cantidad;
	
}



