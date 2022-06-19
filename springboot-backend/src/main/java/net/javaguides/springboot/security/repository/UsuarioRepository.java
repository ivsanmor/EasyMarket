package net.javaguides.springboot.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import net.javaguides.springboot.security.entity.Usuario;

import java.util.List;
import java.util.Optional;

// TODO: Auto-generated Javadoc
/**
 * The Interface UsuarioRepository.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	
	/**
	 * Find by nombre usuario.
	 *
	 * @param nombreUsuario the nombre usuario
	 * @return the optional
	 */
	Optional<Usuario> findByNombreUsuario(String nombreUsuario);

	/**
	 * Exists by nombre usuario.
	 *
	 * @param nombreUsuario the nombre usuario
	 * @return true, if successful
	 */
	boolean existsByNombreUsuario(String nombreUsuario);

	/**
	 * Exists by email.
	 *
	 * @param email the email
	 * @return true, if successful
	 */
	boolean existsByEmail(String email);

	/**
	 * Exists by id.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	boolean existsById(Integer id);
	
	/**
	 * Gets the all usuarios.
	 *
	 * @return the all usuarios
	 */
	@Query("select u from Usuario u where u.activo=true")
	List<Usuario> getAllUsuarios();
	
	/**
	 * Gets the usuario by id.
	 *
	 * @param id the id
	 * @return the usuario by id
	 */
	@Query("select u from Usuario u where u.id= :id and u.activo=true")
	Usuario getUsuarioById(@Param("id") Integer id);
	
	/**
	 * Gets the usuario by nombre.
	 *
	 * @param nombreUsuario the nombre usuario
	 * @return the usuario by nombre
	 */
	@Query("select u from Usuario u where u.nombreUsuario= :nombreUsuario and u.activo=true")
	Usuario getUsuarioByNombre(@Param("nombreUsuario") String nombreUsuario);

	
}