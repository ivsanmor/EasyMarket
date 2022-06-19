package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.dto.ProductoDTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface ProductoService.
 */
public interface ProductoService {
	
	/**
	 * Gets the all productos.
	 *
	 * @return the all productos
	 */
	public List<ProductoDTO> getAllProductos();
	
	/**
	 * Gets the producto by id.
	 *
	 * @param id the id
	 * @return the producto by id
	 * @throws Exception the exception
	 */
	public ProductoDTO getProductoById(Long id) throws Exception;
	
	/**
	 * Gets the producto by oferta.
	 *
	 * @param id_Oferta the id oferta
	 * @return the producto by oferta
	 */
	public ProductoDTO getProductoByOferta(Long id_Oferta);
	
	/**
	 * Delete producto.
	 *
	 * @param id the id
	 * @return the producto DTO
	 * @throws Exception the exception
	 */
	public ProductoDTO deleteProducto(Long id) throws Exception;
	
	/**
	 * Save or update.
	 *
	 * @param producto the producto
	 * @return the producto DTO
	 * @throws Exception the exception
	 */
	public ProductoDTO saveOrUpdate(ProductoDTO producto) throws Exception;
}
