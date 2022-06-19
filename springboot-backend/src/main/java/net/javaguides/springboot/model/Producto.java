package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;


/**
 * Entidad de producto cuyos atributos serviran para almacenar
 * datos en la base de datos.
 * 
 * @author Ivan
 */
@Data
@ToString
@Entity
@Table(name = "producto")
public class Producto {

	/** id autoincrementable de los productos */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**nombre del producto */
	@Column(name = "nombre", nullable = false)
	private String nombre;

	/**cantidad del producto */
	@Column(name = "cantidad")
	private Integer cantidad;

	/**precio del producto */
	@Column(name = "precio")
	private Double precio;

	/**descripcion del producto */
	@Column(name = "descripcion")
	private String descripcion;

	/**imagen del producto */
	@Column(name = "imagen")
	private String imagen;

	/**activo del producto */
	@Column(name = "activo")
	private boolean activo;
	
	/**nombre categoria del producto */
	@Column(name = "categoria")
	private String nombreCategoria;

	/**oferta del producto */
	@ManyToOne
	@JoinColumn(name = "oferta_id")
	private Oferta oferta;

	
	
}
