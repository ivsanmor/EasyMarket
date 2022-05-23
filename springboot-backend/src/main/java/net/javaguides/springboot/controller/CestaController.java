package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.dto.CestaDTO;
import net.javaguides.springboot.service.CestaService;

@RestController
@RequestMapping("/api/cestas")
public class CestaController {
	
	private CestaService cestaService;

	public CestaController(CestaService cestaService) {
		super();
		this.cestaService = cestaService;
	}
	
	// build get all cestas REST API
	@GetMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<CestaDTO> getAllCestas(){
		return cestaService.getAllCestas();
	}
	
	// build get cesta by id REST API
	// http://localhost:8080/api/cestas/1
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public CestaDTO getCestaById(@PathVariable("id") long cestaId) throws Exception{
		return cestaService.getCestaById(cestaId);
	}
	
	
	// build delete cesta REST API
	// http://localhost:8080/api/cestas/1
	@DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public CestaDTO deleteCesta(@PathVariable("id") long id) throws Exception{

		return cestaService.deleteCesta(id);
	}
	
	@PostMapping(value = "/saveOrUpdate", produces = {MediaType.APPLICATION_JSON_VALUE})
	public CestaDTO saveOrUpdate(@RequestBody CestaDTO cesta) throws Exception {
		return cestaService.saveOrUpdate(cesta);
	}
}