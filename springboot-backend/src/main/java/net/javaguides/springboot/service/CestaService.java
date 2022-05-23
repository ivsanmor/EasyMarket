package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.dto.CestaDTO;

public interface CestaService {
	
	public List<CestaDTO> getAllCestas();
	public CestaDTO getCestaById(Long id) throws Exception;
	public CestaDTO deleteCesta(Long id) throws Exception;
	public CestaDTO saveOrUpdate(CestaDTO cesta) throws Exception;
}
