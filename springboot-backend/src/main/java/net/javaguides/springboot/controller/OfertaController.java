package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.dto.OfertaDTO;
import net.javaguides.springboot.service.OfertaService;

// TODO: Auto-generated Javadoc
/**
 * The Class OfertaController.
 */
@RestController
@RequestMapping("/api/ofertas")
@CrossOrigin("*")
public class OfertaController {
	
	/** The oferta service. */
	@Autowired
	private OfertaService ofertaService;

	/**
	 * Instantiates a new oferta controller.
	 *
	 * @param ofertaService the oferta service
	 */
	public OfertaController(OfertaService ofertaService) {
		super();
		this.ofertaService = ofertaService;
	}
	
	
	/**
	 * Gets the all ofertas.
	 *
	 * @return the all ofertas
	 */
	// build get all ofertas REST API
	@GetMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<OfertaDTO> getAllOfertas(){
		return ofertaService.getAllOfertas();
	}
	
	// build get oferta by id REST API
	/**
	 * Gets the oferta by id.
	 *
	 * @param ofertaId the oferta id
	 * @return the oferta by id
	 * @throws Exception the exception
	 */
	// http://localhost:8080/api/ofertas/1
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public OfertaDTO getOfertaById(@PathVariable("id") long ofertaId) throws Exception{
		return ofertaService.getOfertaById(ofertaId);
	}
	
	
	// build delete oferta REST API
	/**
	 * Delete oferta.
	 *
	 * @param id the id
	 * @return the oferta DTO
	 * @throws Exception the exception
	 */
	// http://localhost:8080/api/ofertas/1
	@DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public OfertaDTO deleteOferta(@PathVariable("id") long id) throws Exception{

		return ofertaService.deleteOferta(id);
	}
	
	/**
	 * Save or update.
	 *
	 * @param oferta the oferta
	 * @return the oferta DTO
	 * @throws Exception the exception
	 */
	@PostMapping(value = "/saveOrUpdate", produces = {MediaType.APPLICATION_JSON_VALUE})
	public OfertaDTO saveOrUpdate(@RequestBody OfertaDTO oferta) throws Exception {
		return ofertaService.saveOrUpdate(oferta);
	}
	
	
}
