package net.javaguides.springboot.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.javaguides.springboot.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

	@Query("select p from Producto p where p.oferta= :id")
	Producto findByOfertaId(@Param("id") long id);
}
