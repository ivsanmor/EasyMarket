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

import net.javaguides.springboot.dto.CategoriaDTO;
import net.javaguides.springboot.service.CategoriaService;


/**
 * The Class CategoriaController.
 */
@RestController
@RequestMapping("/api/categorias")
@CrossOrigin("*")
public class CategoriaController {

	/** The categoria service. */
	private CategoriaService categoriaService;

	/**
	 * Instantiates a new categoria controller.
	 *
	 * @param categoriaService the categoria service
	 */
	public CategoriaController(CategoriaService categoriaService) {
		super();
		this.categoriaService = categoriaService;
	}

	/**
	 * Gets the all categorias.
	 *
	 * @return the all categorias
	 */
	// build get all categorias REST API
	@GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<CategoriaDTO> getAllCategorias() {
		return categoriaService.getAllCategorias();
	}

	// build get categoria by id REST API
	/**
	 * Gets the categoria by id.
	 *
	 * @param categoriaId the categoria id
	 * @return the categoria by id
	 * @throws Exception the exception
	 */
	// http://localhost:8080/api/categorias/1
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public CategoriaDTO getCategoriaById(@PathVariable("id") Long categoriaId) throws Exception {
		return categoriaService.getCategoriaById(categoriaId);
	}

	// build delete categoria REST API
	/**
	 * Delete categoria.
	 *
	 * @param id the id
	 * @return the categoria DTO
	 * @throws Exception the exception
	 */
	// http://localhost:8080/api/categorias/1
	@DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public CategoriaDTO deleteCategoria(@PathVariable("id") Long id) throws Exception {

		return categoriaService.deleteCategoria(id);
	}

	/**
	 * Save or update.
	 *
	 * @param categoria the categoria
	 * @return the categoria DTO
	 * @throws Exception the exception
	 */
	@PostMapping(value = "/saveOrUpdate", produces = { MediaType.APPLICATION_JSON_VALUE })
	public CategoriaDTO saveOrUpdate(@RequestBody CategoriaDTO categoria) throws Exception {
		return categoriaService.saveOrUpdate(categoria);
	}

	/**
	 * Gets the nombres categorias.
	 *
	 * @return the nombres categorias
	 */
	// build get all categorias REST API
	@GetMapping(value = "/nombres", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<String> getNombresCategorias() {
		return categoriaService.getNombresCategorias();
	}

	// build get categoria by id REST API
	/**
	 * Gets the categoria by nombre.
	 *
	 * @param nombre the nombre
	 * @return the categoria by nombre
	 * @throws Exception the exception
	 */
	// http://localhost:8080/api/categorias/1
	@PostMapping(value = "/nombre", produces = { MediaType.APPLICATION_JSON_VALUE })
	public CategoriaDTO getCategoriaByNombre(@RequestBody String nombre) throws Exception {
		return categoriaService.getCategoriaByNombre(nombre);
	}

}
