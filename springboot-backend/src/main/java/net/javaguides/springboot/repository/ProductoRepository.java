package net.javaguides.springboot.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.javaguides.springboot.model.Producto;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProductoRepository.
 */
public interface ProductoRepository extends JpaRepository<Producto, Long>{
	
	/**
	 * Gets the all productos.
	 *
	 * @return the all productos
	 */
	@Query("select p from Producto p where p.activo=true")
	List<Producto> getAllProductos();
	
	
	/**
	 * Gets the producto by id.
	 *
	 * @param id the id
	 * @return the producto by id
	 */
	@Query("select p from Producto p where p.id= :id and p.activo=true")
	Producto getProductoById(@Param("id") Long id);

	/**
	 * Find by oferta id.
	 *
	 * @param id the id
	 * @return the producto
	 */
	@Query("select p from Producto p where p.oferta= :id")
	Producto findByOfertaId(@Param("id") Long id);
}
