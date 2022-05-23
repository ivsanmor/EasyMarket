package net.javaguides.springboot.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springboot.security.entity.Usuario;
import net.javaguides.springboot.security.repository.UsuarioRepository;

import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
		return usuarioRepository.findByNombreUsuario(nombreUsuario);
	}

	public boolean existsByNombreUsuario(String nombreUsuario) {
		return usuarioRepository.existsByNombreUsuario(nombreUsuario);
	}

	public boolean existsByEmail(String email) {
		return usuarioRepository.existsByEmail(email);
	}

	public boolean existsById(Integer id) {
		return usuarioRepository.existsById(id);
	}

	public void save(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
}
