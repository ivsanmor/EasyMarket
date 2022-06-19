package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Entidad de categoria cuyos atributos serviran para almacenar
 * datos en la base de datos.
 * 
 * @author Ivan
 */
@Data
@Entity
@Table(name = "categoria")
public class Categoria {
	
	/** id autoincrementable de los categorias */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** nombre de la categoria */
	@Column(name = "nombre", nullable = false)
	private String nombre;

	/** activo de la categoria  */
	@Column(name = "activo")
	private boolean activo;

}
