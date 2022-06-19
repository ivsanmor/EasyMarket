package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.dto.CategoriaDTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface CategoriaService.
 */
public interface CategoriaService {
	
	/**
	 * Gets the all categorias.
	 *
	 * @return the all categorias
	 */
	public List<CategoriaDTO> getAllCategorias();
	
	/**
	 * Gets the nombres categorias.
	 *
	 * @return the nombres categorias
	 */
	public List<String> getNombresCategorias();
	
	/**
	 * Gets the categoria by id.
	 *
	 * @param id the id
	 * @return the categoria by id
	 * @throws Exception the exception
	 */
	public CategoriaDTO getCategoriaById(Long id) throws Exception;
	
	/**
	 * Gets the categoria by nombre.
	 *
	 * @param nombre the nombre
	 * @return the categoria by nombre
	 * @throws Exception the exception
	 */
	public CategoriaDTO getCategoriaByNombre (String nombre) throws Exception;
	
	/**
	 * Delete categoria.
	 *
	 * @param id the id
	 * @return the categoria DTO
	 * @throws Exception the exception
	 */
	public CategoriaDTO deleteCategoria(Long id) throws Exception;
	
	/**
	 * Save or update.
	 *
	 * @param categoria the categoria
	 * @return the categoria DTO
	 * @throws Exception the exception
	 */
	public CategoriaDTO saveOrUpdate(CategoriaDTO categoria) throws Exception;
}
