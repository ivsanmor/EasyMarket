package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.dto.OfertaDTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface OfertaService.
 */
public interface OfertaService {
	
	/**
	 * Gets the all ofertas.
	 *
	 * @return the all ofertas
	 */
	public List<OfertaDTO> getAllOfertas();
	
	/**
	 * Gets the oferta by id.
	 *
	 * @param id the id
	 * @return the oferta by id
	 * @throws Exception the exception
	 */
	public OfertaDTO getOfertaById(Long id) throws Exception;
	
	/**
	 * Delete oferta.
	 *
	 * @param id the id
	 * @return the oferta DTO
	 * @throws Exception the exception
	 */
	public OfertaDTO deleteOferta(Long id) throws Exception;
	
	/**
	 * Save or update.
	 *
	 * @param producto the producto
	 * @return the oferta DTO
	 * @throws Exception the exception
	 */
	public OfertaDTO saveOrUpdate(OfertaDTO producto) throws Exception;
}
