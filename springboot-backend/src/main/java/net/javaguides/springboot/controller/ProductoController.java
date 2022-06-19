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
import net.javaguides.springboot.service.ProductoService;

// TODO: Auto-generated Javadoc
/**
 * The Class ProductoController.
 */
@RestController
@RequestMapping("/api/productos")
@CrossOrigin("*")
public class ProductoController {

	
	/** The producto service. */
	private ProductoService productoService;

	/**
	 * Instantiates a new producto controller.
	 *
	 * @param productoService the producto service
	 */
	public ProductoController(ProductoService productoService) {
		super();
		this.productoService = productoService;
	}
	
	
	/**
	 * Gets the all productos.
	 *
	 * @return the all productos
	 */
	// build get all productos REST API
	@GetMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<ProductoDTO> getAllProductos(){
		return productoService.getAllProductos();
	}
	
	// build get producto by id REST API
	/**
	 * Gets the producto by id.
	 *
	 * @param productoId the producto id
	 * @return the producto by id
	 * @throws Exception the exception
	 */
	// http://localhost:8080/api/productos/1
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ProductoDTO getProductoById(@PathVariable("id") Long productoId) throws Exception{
		return productoService.getProductoById(productoId);
	}
	
	
	// build delete producto REST API
	/**
	 * Delete producto.
	 *
	 * @param id the id
	 * @return the producto DTO
	 * @throws Exception the exception
	 */
	// http://localhost:8080/api/productos/1
	@DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ProductoDTO deleteProducto(@PathVariable("id") Long id) throws Exception{
		return productoService.deleteProducto(id);
	}
	
	/**
	 * Save or update.
	 *
	 * @param producto the producto
	 * @return the producto DTO
	 * @throws Exception the exception
	 */
	@PostMapping(value = "/saveOrUpdate", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ProductoDTO saveOrUpdate(@RequestBody ProductoDTO producto) throws Exception {
		return productoService.saveOrUpdate(producto);
	}
	
}
