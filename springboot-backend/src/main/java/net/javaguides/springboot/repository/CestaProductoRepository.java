package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import net.javaguides.springboot.model.CestaProducto;

// TODO: Auto-generated Javadoc
/**
 * The Interface CestaProductoRepository.
 */
public interface CestaProductoRepository extends JpaRepository<CestaProducto, Long>{
	
	/**
	 * Gets the productos by cestas.
	 *
	 * @param idCesta the id cesta
	 * @return the productos by cestas
	 */
	@Query("select c from CestaProducto c where c.cesta= :idCesta")
	List<CestaProducto> getProductosByCestas(Long idCesta);
	
}
