package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.dto.CategoriaDTO;

public interface CategoriaService {
	
	public List<CategoriaDTO> getAllCategorias();
	public CategoriaDTO getCategoriaById(Long id) throws Exception;
	public CategoriaDTO deleteCategoria(Long id) throws Exception;
	public CategoriaDTO saveOrUpdate(CategoriaDTO categoria) throws Exception;
}
