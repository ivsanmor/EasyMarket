package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.dto.OfertaDTO;

public interface OfertaService {
	
	public List<OfertaDTO> getAllOfertas();
	public OfertaDTO getOfertaById(Long id) throws Exception;
	public OfertaDTO deleteOferta(Long id) throws Exception;
	public OfertaDTO saveOrUpdate(OfertaDTO producto) throws Exception;
}
