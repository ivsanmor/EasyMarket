package net.javaguides.springboot.dto;


import lombok.Data;

/**
 * DTO de categoria cuyos atributos
 * @author Ivan
 */
@Data
public class CategoriaDTO {

	/** id autoincrementable de los categorias */
	private Long id;
	
	/** nombre de la categoria */
	private String nombre;

	/** activo de la categoria  */
	private boolean activo;

}
