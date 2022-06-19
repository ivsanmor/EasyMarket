package net.javaguides.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javassist.tools.rmi.ObjectNotFoundException;
import net.javaguides.springboot.dto.CategoriaDTO;
import net.javaguides.springboot.model.Categoria;
import net.javaguides.springboot.repository.CategoriaRepository;
import net.javaguides.springboot.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	private CategoriaRepository categoriaRepository;

	public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
		super();
		this.categoriaRepository = categoriaRepository;
	}

	@Override
	public List<CategoriaDTO> getAllCategorias() {

		List<CategoriaDTO> categoriasDto = new ArrayList<CategoriaDTO>();

		List<Categoria> categorias = categoriaRepository.getAllCategorias();
		ModelMapper modelMapper = new ModelMapper();
		for (Categoria categoria : categorias) {

			CategoriaDTO categoriaDto = modelMapper.map(categoria, CategoriaDTO.class);
			categoriasDto.add(categoriaDto);
		}

		return categoriasDto;

	}

	@Override
	public CategoriaDTO getCategoriaById(Long id) throws Exception {

		CategoriaDTO categoriaDto = null;
		ModelMapper modelMapper = new ModelMapper();
		if (id != 0) {

			Categoria categoria = categoriaRepository.getCategoriaById(id);

			if (categoria != null) {
				categoriaDto = modelMapper.map(categoria, CategoriaDTO.class);
			} else {
				throw new ObjectNotFoundException("No existe categoria con el id: " + id);
			}
		} else {
			throw new Exception("Id del categoria vacío");
		}

		return categoriaDto;
	}

	@Override
	public CategoriaDTO deleteCategoria(Long id) throws Exception {

		CategoriaDTO categoriaDto = null;

		ModelMapper modelMapper = new ModelMapper();
		if (id != 0) {

			Optional<Categoria> opCategoria = categoriaRepository.findById(id);

			Categoria categoriaModel = null;

			if (opCategoria.isPresent()) {
				categoriaModel = opCategoria.get();
				categoriaModel.setActivo(Boolean.FALSE);

				categoriaModel = categoriaRepository.save(categoriaModel);
				categoriaDto = modelMapper.map(categoriaModel, CategoriaDTO.class);

			} else {
				throw new ObjectNotFoundException("Categoria con id : " + id + " , no encontrado");
			}

		} else {
			throw new Exception("Categoria vacío");
		}

		return categoriaDto;
	}

	@Override
	public CategoriaDTO saveOrUpdate(CategoriaDTO categoria) throws Exception {

		CategoriaDTO categoriaDto = null;
		ModelMapper modelMapper = new ModelMapper();

		if (categoria != null) {
			Categoria categoriaModel = modelMapper.map(categoria, Categoria.class);
			if (categoriaModel.isActivo() == false) {
				categoriaModel.setActivo(Boolean.TRUE);
			}
			categoriaModel = categoriaRepository.save(categoriaModel);
			categoriaDto = modelMapper.map(categoriaModel, CategoriaDTO.class);

		} else {
			throw new Exception("Categoria vacío");
		}

		return categoriaDto;
	}

	@Override
	public List<String> getNombresCategorias() {
		 return categoriaRepository.getNombresCategorias();

	}

	@Override
	public CategoriaDTO getCategoriaByNombre(String nombre) throws Exception {
		CategoriaDTO categoriaDto = null;
		ModelMapper modelMapper = new ModelMapper();
		if (!nombre.isEmpty()) {

			Categoria categoria = categoriaRepository.getCategoriaByNombre(nombre);

			if (categoria != null) {
				categoriaDto = modelMapper.map(categoria, CategoriaDTO.class);
			} else {
				throw new ObjectNotFoundException("No existe categoria con el nombre: " + nombre);
			}
		} else {
			throw new Exception("Id del categoria vacío");
		}

		return categoriaDto;
	}

}
