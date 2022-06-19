package net.javaguides.springboot.security.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javassist.tools.rmi.ObjectNotFoundException;
import net.javaguides.springboot.dto.ProductoDTO;
import net.javaguides.springboot.dto.UsuarioDTO;
import net.javaguides.springboot.model.Producto;
import net.javaguides.springboot.security.entity.Usuario;
import net.javaguides.springboot.security.repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioService.
 */
@Service
@Transactional
public class UsuarioService {

	/** The usuario repository. */
	@Autowired
	UsuarioRepository usuarioRepository;
	
	/** The password encoder. */
	@Autowired
	PasswordEncoder passwordEncoder;

	
	/**
	 * Gets the usuarios.
	 *
	 * @return the usuarios
	 */
	public List<UsuarioDTO> getUsuarios(){
		List<UsuarioDTO> usuariosDto = new ArrayList<UsuarioDTO>();
		
		List<Usuario> usuarios = usuarioRepository.getAllUsuarios();
		ModelMapper modelMapper = new ModelMapper();
		for (Usuario usuario : usuarios) {
			
			UsuarioDTO usuarioDto = modelMapper.map(usuario, UsuarioDTO.class);
			usuariosDto.add(usuarioDto);
		}
		return usuariosDto;
	}
	
	/**
	 * Gets the by nombre.
	 *
	 * @param nombreUsuario the nombre usuario
	 * @return the by nombre
	 * @throws Exception the exception
	 */
	public UsuarioDTO getByNombre(String nombreUsuario) throws Exception {
		UsuarioDTO usuarioDto = null;
		ModelMapper modelMapper = new ModelMapper();
		if (!nombreUsuario.isEmpty()) {
			
			Usuario usuario = usuarioRepository.getUsuarioByNombre(nombreUsuario);
			
			if (usuario != null) {
				usuarioDto = modelMapper.map(usuario, UsuarioDTO.class);
			} else {
				throw new ObjectNotFoundException("No existe usuario con el nombre: " + nombreUsuario);
			}
		}else {
			throw new Exception("Nombre del usuario vacío");
		}
		
		return usuarioDto;
	}
	
	/**
	 * Gets the by id usuario.
	 *
	 * @param id the id
	 * @return the by id usuario
	 * @throws Exception the exception
	 */
	public UsuarioDTO getByIdUsuario(Integer id) throws Exception {
		UsuarioDTO usuarioDto = null;
		ModelMapper modelMapper = new ModelMapper();
		if (id != 0) {
			
			Usuario usuario = usuarioRepository.getUsuarioById(id);
			
			if (usuario != null) {
				usuarioDto = modelMapper.map(usuario, UsuarioDTO.class);
			} else {
				throw new ObjectNotFoundException("No existe usuario con el id: " + id);
			}
		}else {
			throw new Exception("Id del usuario vacío");
		}
		
		return usuarioDto;
	
	}
	
	
	/**
	 * Update.
	 *
	 * @param usuario the usuario
	 * @return the usuario DTO
	 * @throws Exception the exception
	 */
	public UsuarioDTO update(UsuarioDTO usuario) throws Exception {

		UsuarioDTO usuarioDto = null;
		ModelMapper modelMapper = new ModelMapper();
		if (usuario != null) {
			Usuario usuarioModel = modelMapper.map(usuario, Usuario.class);
			if(usuarioModel.isActivo() == false) {
				usuarioModel.setActivo(Boolean.TRUE);
			}
			
			usuarioModel = usuarioRepository.save(usuarioModel);
			usuarioDto = modelMapper.map(usuarioModel, UsuarioDTO.class);
			
		}
		
		return usuarioDto;
	}
	
	/**
	 * Gets the by nombre usuario.
	 *
	 * @param nombreUsuario the nombre usuario
	 * @return the by nombre usuario
	 */
	public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
		return usuarioRepository.findByNombreUsuario(nombreUsuario);
	}
	
	

	/**
	 * Exists by nombre usuario.
	 *
	 * @param nombreUsuario the nombre usuario
	 * @return true, if successful
	 */
	public boolean existsByNombreUsuario(String nombreUsuario) {
		return usuarioRepository.existsByNombreUsuario(nombreUsuario);
	}

	/**
	 * Exists by email.
	 *
	 * @param email the email
	 * @return true, if successful
	 */
	public boolean existsByEmail(String email) {
		return usuarioRepository.existsByEmail(email);
	}

	/**
	 * Exists by id.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	public boolean existsById(Integer id) {
		return usuarioRepository.existsById(id);
	}

	/**
	 * Save.
	 *
	 * @param usuario the usuario
	 */
	public void save(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
}
