package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.dto.ProductoDTO;
import net.javaguides.springboot.dto.UsuarioDTO;
import net.javaguides.springboot.security.service.UsuarioService;

// TODO: Auto-generated Javadoc
/**
 * The Class UsuarioController.
 */
@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin("*")
public class UsuarioController {

	
	/** The usuario service. */
	private UsuarioService usuarioService;

	/**
	 * Instantiates a new usuario controller.
	 *
	 * @param usuarioService the usuario service
	 */
	public UsuarioController(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}
	
	
	/**
	 * Gets the all usuarios.
	 *
	 * @return the all usuarios
	 */
	// build get all usuarios REST API
	@GetMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<UsuarioDTO> getAllUsuarios(){
		return usuarioService.getUsuarios();
	}
	// build get usuario by id REST API
	/**
	 * Gets the usuario by id.
	 *
	 * @param usuarioId the usuario id
	 * @return the usuario by id
	 * @throws Exception the exception
	 */
	// http://localhost:8080/api/usuarios/1
	@GetMapping(value = "/id/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public UsuarioDTO getUsuarioById(@PathVariable("id") Integer usuarioId) throws Exception{
		return usuarioService.getByIdUsuario(usuarioId);
	}
	
	// build get usuario by id REST API
		/**
	 * Gets the usuario by nombre.
	 *
	 * @param nombreUsuario the nombre usuario
	 * @return the usuario by nombre
	 * @throws Exception the exception
	 */
	// http://localhost:8080/api/usuarios/1
		@GetMapping(value = "/nombre/{nombreUsuario}", produces = {MediaType.APPLICATION_JSON_VALUE})
		public UsuarioDTO getUsuarioByNombre(@PathVariable("nombreUsuario") String nombreUsuario) throws Exception{
			return usuarioService.getByNombre(nombreUsuario);
		}
	
		/**
		 * Save or update.
		 *
		 * @param usuario the usuario
		 * @return the usuario DTO
		 * @throws Exception the exception
		 */
		@PostMapping(value = "/usuario/update", produces = {MediaType.APPLICATION_JSON_VALUE})
		public UsuarioDTO saveOrUpdate(@RequestBody UsuarioDTO usuario) throws Exception {
			return usuarioService.update(usuario);
		}
//	// build delete usuario REST API
//	// http://localhost:8080/api/usuarios/1
//	@DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
//	public UsuarioDTO deleteUsuario(@PathVariable("id") Integer id) throws Exception{
//		return usuarioService(id);
//	}
	
	
}
