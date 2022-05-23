package net.javaguides.springboot.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.security.entity.Usuario;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	Optional<Usuario> findByNombreUsuario(String nombreUsuario);

	boolean existsByNombreUsuario(String nombreUsuario);

	boolean existsByEmail(String email);

	boolean existsById(Integer id);

}