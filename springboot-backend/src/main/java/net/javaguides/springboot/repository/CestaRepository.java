package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.javaguides.springboot.model.Cesta;

// TODO: Auto-generated Javadoc
/**
 * The Interface CestaRepository.
 */
public interface CestaRepository extends JpaRepository<Cesta, Long>{

	/**
	 * Gets the all cestas.
	 *
	 * @return the all cestas
	 */
	@Query("select c from Cesta c where c.activo=true")
	List<Cesta> getAllCestas();
	
	
	/**
	 * Gets the cesta by id.
	 *
	 * @param id the id
	 * @return the cesta by id
	 */
	@Query("select c from Cesta c where c.id= :id and c.activo=true")
	Cesta getCestaById(@Param("id") Long id);
}
