package net.javaguides.springboot.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.security.entity.Rol;
import net.javaguides.springboot.security.enums.RolNombre;

import java.util.Optional;

// TODO: Auto-generated Javadoc
/**
 * The Interface RolRepository.
 */
@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
	
	/**
	 * Find by rol nombre.
	 *
	 * @param rolNombre the rol nombre
	 * @return the optional
	 */
	Optional<Rol> findByRolNombre(RolNombre rolNombre);
}