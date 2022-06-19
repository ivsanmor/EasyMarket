package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.dto.CestaDTO;
import net.javaguides.springboot.dto.CestaProductoDTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface CestaService.
 */
public interface CestaService {
	
	/**
	 * Gets the all cestas.
	 *
	 * @return the all cestas
	 */
	public List<CestaDTO> getAllCestas();
	
	/**
	 * Gets the cesta by id.
	 *
	 * @param id the id
	 * @return the cesta by id
	 * @throws Exception the exception
	 */
	public CestaDTO getCestaById(Long id) throws Exception;
	
	/**
	 * Delete cesta.
	 *
	 * @param id the id
	 * @return the cesta DTO
	 * @throws Exception the exception
	 */
	public CestaDTO deleteCesta(Long id) throws Exception;
	
	/**
	 * Save or update.
	 *
	 * @param cesta the cesta
	 * @return the cesta DTO
	 * @throws Exception the exception
	 */
	public CestaDTO saveOrUpdate(CestaDTO cesta) throws Exception;
	
	/**
	 * Save cesta producto.
	 *
	 * @param cestaProducto the cesta producto
	 * @return the cesta producto DTO
	 * @throws Exception the exception
	 */
	public CestaProductoDTO saveCestaProducto(CestaProductoDTO cestaProducto) throws Exception;
	
	/**
	 * Gets the productos by cesta.
	 *
	 * @param id the id
	 * @return the productos by cesta
	 */
	public List<CestaProductoDTO> getProductosByCesta(Long id);
}
