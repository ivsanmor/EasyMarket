package net.javaguides.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javassist.tools.rmi.ObjectNotFoundException;
import net.javaguides.springboot.dto.OfertaDTO;
import net.javaguides.springboot.model.Oferta;
import net.javaguides.springboot.repository.OfertaRepository;
import net.javaguides.springboot.service.OfertaService;

@Service
public class OfertaServiceImpl implements OfertaService{

	private OfertaRepository ofertaRepository;
	
	@Override
	public List<OfertaDTO> getAllOfertas() {
		
		List<OfertaDTO> ofertasDto = new ArrayList<OfertaDTO>();
		
		List<Oferta> ofertas = ofertaRepository.findAll();
		ModelMapper modelMapper = new ModelMapper();
		for (Oferta oferta : ofertas) {
			
			OfertaDTO ofertaDto = modelMapper.map(oferta, OfertaDTO.class);
			ofertasDto.add(ofertaDto);
		}
		
		
		return ofertasDto;
		
	}

	@Override
	public OfertaDTO getOfertaById(Long id) throws Exception {

		OfertaDTO ofertaDto = null;
		ModelMapper modelMapper = new ModelMapper();
		if (id != 0) {
			
			Oferta oferta = ofertaRepository.getById(id);
			
			if (oferta != null) {
				ofertaDto = modelMapper.map(oferta, OfertaDTO.class);
			} else {
				throw new ObjectNotFoundException("No existe oferta con el id: " + id);
			}
		}else {
			throw new Exception("Id del oferta vacío");
		}
		
		return ofertaDto;
	}


	@Override
	public OfertaDTO deleteOferta(Long id) throws Exception {
		
		OfertaDTO ofertaDto = null;

		ModelMapper modelMapper = new ModelMapper();
		if (id != 0) {
			
			Optional<Oferta> opOferta = ofertaRepository.findById(id);
			
			Oferta ofertaModel = null;
			
			if (opOferta.isPresent()) {
				ofertaModel = opOferta.get();
				ofertaModel.setActivo(Boolean.FALSE);
				
				ofertaModel = ofertaRepository.save(ofertaModel);
				ofertaDto = modelMapper.map(ofertaModel, OfertaDTO.class);
				
			}else {
				throw new ObjectNotFoundException("Oferta con id : " + id  + " , no encontrado");
			}
			
		} else {
			throw new Exception("Oferta vacío");
		}
		
		return ofertaDto;
	}



	@Override
	public OfertaDTO saveOrUpdate(OfertaDTO oferta) throws Exception {

		OfertaDTO ofertaDto = null;
		ModelMapper modelMapper = new ModelMapper();
		
		if (oferta != null) {
			Oferta ofertaModel = modelMapper.map(oferta, Oferta.class);
			if(ofertaModel.isActivo() == false) {
				ofertaModel.setActivo(Boolean.TRUE);
			}
			
			ofertaModel = ofertaRepository.save(ofertaModel);
			ofertaDto = modelMapper.map(ofertaModel, OfertaDTO.class);
			
		}else {
			throw new Exception("Oferta vacío");
		}
		
		return ofertaDto;
	}
}
