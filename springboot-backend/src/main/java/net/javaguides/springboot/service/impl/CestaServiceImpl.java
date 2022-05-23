package net.javaguides.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javassist.tools.rmi.ObjectNotFoundException;
import net.javaguides.springboot.dto.CestaDTO;
import net.javaguides.springboot.model.Cesta;
import net.javaguides.springboot.repository.CestaRepository;
import net.javaguides.springboot.service.CestaService;

@Service
public class CestaServiceImpl implements CestaService{
	
	private CestaRepository cestaRepository;
	
	@Override
	public List<CestaDTO> getAllCestas() {
		
		List<CestaDTO> cestasDto = new ArrayList<CestaDTO>();
		
		List<Cesta> cestas = cestaRepository.findAll();
		ModelMapper modelMapper = new ModelMapper();
		for (Cesta cesta : cestas) {
			
			CestaDTO cestaDto = modelMapper.map(cesta, CestaDTO.class);
			cestasDto.add(cestaDto);
		}
		
		
		return cestasDto;
		
	}

	@Override
	public CestaDTO getCestaById(Long id) throws Exception {

		CestaDTO cestaDto = null;
		ModelMapper modelMapper = new ModelMapper();
		if (id != 0) {
			
			Cesta cesta = cestaRepository.getById(id);
			
			if (cesta != null) {
				cestaDto = modelMapper.map(cesta, CestaDTO.class);
			} else {
				throw new ObjectNotFoundException("No existe cesta con el id: " + id);
			}
		}else {
			throw new Exception("Id del cesta vacío");
		}
		
		return cestaDto;
	}


	@Override
	public CestaDTO deleteCesta(Long id) throws Exception {
		
		CestaDTO cestaDto = null;

		ModelMapper modelMapper = new ModelMapper();
		if (id != 0) {
			
			Optional<Cesta> opCesta = cestaRepository.findById(id);
			
			Cesta cestaModel = null;
			
			if (opCesta.isPresent()) {
				cestaModel = opCesta.get();
				cestaModel.setActivo(Boolean.FALSE);
				
				cestaModel = cestaRepository.save(cestaModel);
				cestaDto = modelMapper.map(cestaModel, CestaDTO.class);
				
			}else {
				throw new ObjectNotFoundException("Cesta con id : " + id  + " , no encontrado");
			}
			
		} else {
			throw new Exception("Cesta vacío");
		}
		
		return cestaDto;
	}



	@Override
	public CestaDTO saveOrUpdate(CestaDTO cesta) throws Exception {

		CestaDTO cestaDto = null;
		ModelMapper modelMapper = new ModelMapper();
		
		if (cesta != null && cesta.getUsuarioId() != null) {
			Cesta cestaModel = modelMapper.map(cesta, Cesta.class);
			if (cestaModel.isActivo() == false) {
				cestaModel.setActivo(Boolean.TRUE);
			}
			
			cestaModel = cestaRepository.save(cestaModel);
			cestaDto = modelMapper.map(cestaModel, CestaDTO.class);
			
		}else {
			throw new Exception("Cesta vacío");
		}
		
		return cestaDto;
	}

}
