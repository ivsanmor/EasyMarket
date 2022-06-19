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
import net.javaguides.springboot.security.entity.Usuario;

/**
 * Entidad de cesta cuyos atributos serviran para almacenar
 * datos en la base de datos.
 * 
 * @author Ivan
 */
@Data
@Entity
@Table(name = "cesta")
public class Cesta {

	/** id autoincrementable de las cestas */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** precio total de las cestas */
	@Column(name = "precio_total")
	private Double precioTotal;

	/** observaciones de las cestas */
	@Column(name = "observaciones")
	private String observaciones;

	/** activo de las cestas */
	@Column(name = "activo")
	private boolean activo;

	/** usuario al que pertenece la cesta */
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	Usuario usuario;




	
}
