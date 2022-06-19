package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.javaguides.springboot.model.Categoria;

// TODO: Auto-generated Javadoc
/**
 * The Interface CategoriaRepository.
 */
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	/**
	 * Gets the all categorias.
	 *
	 * @return the all categorias
	 */
	@Query("select c from Categoria c where c.activo=true")
	List<Categoria> getAllCategorias();
	
	/**
	 * Gets the nombres categorias.
	 *
	 * @return the nombres categorias
	 */
	@Query("select nombre from Categoria c where c.activo=true")
	List<String> getNombresCategorias();
	
	/**
	 * Gets the categoria by id.
	 *
	 * @param id the id
	 * @return the categoria by id
	 */
	@Query("select c from Categoria c where c.id= :id and c.activo=true")
	Categoria getCategoriaById(@Param("id") Long id);
	
	/**
	 * Gets the categoria by nombre.
	 *
	 * @param nombre the nombre
	 * @return the categoria by nombre
	 */
	@Query("select c from Categoria c where c.nombre= :nombre and c.activo=true")
	Categoria getCategoriaByNombre(@Param("nombre") String nombre);
}
