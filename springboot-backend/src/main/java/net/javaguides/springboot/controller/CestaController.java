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

import net.javaguides.springboot.dto.CestaDTO;
import net.javaguides.springboot.dto.CestaProductoDTO;
import net.javaguides.springboot.service.CestaService;

// TODO: Auto-generated Javadoc
/**
 * The Class CestaController.
 */
@RestController
@RequestMapping("/api/cestas")
@CrossOrigin("*")
public class CestaController {
	
	/** The cesta service. */
	private CestaService cestaService;

	/**
	 * Instantiates a new cesta controller.
	 *
	 * @param cestaService the cesta service
	 */
	public CestaController(CestaService cestaService) {
		super();
		this.cestaService = cestaService;
	}
	
	/**
	 * Gets the all cestas.
	 *
	 * @return the all cestas
	 */
	// build get all cestas REST API
	@GetMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<CestaDTO> getAllCestas(){
		return cestaService.getAllCestas();
	}
	
	// build get cesta by id REST API
	/**
	 * Gets the cesta by id.
	 *
	 * @param cestaId the cesta id
	 * @return the cesta by id
	 * @throws Exception the exception
	 */
	// http://localhost:8080/api/cestas/1
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public CestaDTO getCestaById(@PathVariable("id") Long cestaId) throws Exception{
		return cestaService.getCestaById(cestaId);
	}
	
	
	// build delete cesta REST API
	/**
	 * Delete cesta.
	 *
	 * @param id the id
	 * @return the cesta DTO
	 * @throws Exception the exception
	 */
	// http://localhost:8080/api/cestas/1
	@DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public CestaDTO deleteCesta(@PathVariable("id") Long id) throws Exception{
		return cestaService.deleteCesta(id);
	}
	
	/**
	 * Save or update.
	 *
	 * @param cesta the cesta
	 * @return the cesta DTO
	 * @throws Exception the exception
	 */
	@PostMapping(value = "/saveOrUpdate", produces = {MediaType.APPLICATION_JSON_VALUE})
	public CestaDTO saveOrUpdate(@RequestBody CestaDTO cesta) throws Exception {
		return cestaService.saveOrUpdate(cesta);
	}
	
	
	/**
	 * Save cesta producto.
	 *
	 * @param cestaProducto the cesta producto
	 * @return the cesta producto DTO
	 * @throws Exception the exception
	 */
	@PostMapping(value = "/cestaProducto/saveOrUpdate", produces = {MediaType.APPLICATION_JSON_VALUE})
	public CestaProductoDTO saveCestaProducto(@RequestBody CestaProductoDTO cestaProducto) throws Exception {
		return cestaService.saveCestaProducto(cestaProducto);
	}
	
	/**
	 * Gets the productos by cesta.
	 *
	 * @param cestaId the cesta id
	 * @return the productos by cesta
	 */
	@GetMapping(value = "/cestaProducto/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<CestaProductoDTO> getProductosByCesta(@PathVariable("id") Long cestaId){
		return cestaService.getProductosByCesta(cestaId);
	}
}