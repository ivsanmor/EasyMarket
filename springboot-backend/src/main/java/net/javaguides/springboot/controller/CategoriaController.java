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

import net.javaguides.springboot.dto.CategoriaDTO;
import net.javaguides.springboot.service.CategoriaService;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
	
	private CategoriaService categoriaService;

	public CategoriaController(CategoriaService categoriaService) {
		super();
		this.categoriaService = categoriaService;
	}
	
	// build get all categorias REST API
	@GetMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<CategoriaDTO> getAllCategorias(){
		return categoriaService.getAllCategorias();
	}
	
	// build get categoria by id REST API
	// http://localhost:8080/api/categorias/1
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public CategoriaDTO getCategoriaById(@PathVariable("id") long categoriaId) throws Exception{
		return categoriaService.getCategoriaById(categoriaId);
	}
	
	
	// build delete categoria REST API
	// http://localhost:8080/api/categorias/1
	@DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public CategoriaDTO deleteCategoria(@PathVariable("id") long id) throws Exception{

		return categoriaService.deleteCategoria(id);
	}
	
	@PostMapping(value = "/saveOrUpdate", produces = {MediaType.APPLICATION_JSON_VALUE})
	public CategoriaDTO saveOrUpdate(@RequestBody CategoriaDTO categoria) throws Exception {
		return categoriaService.saveOrUpdate(categoria);
	}
	
}
