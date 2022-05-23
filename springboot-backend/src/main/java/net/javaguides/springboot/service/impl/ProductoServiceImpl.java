package net.javaguides.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javassist.tools.rmi.ObjectNotFoundException;
import net.javaguides.springboot.dto.ProductoDTO;
import net.javaguides.springboot.model.Producto;
import net.javaguides.springboot.repository.ProductoRepository;
import net.javaguides.springboot.service.ProductoService;

@Service("productoService")
@Lazy
public class ProductoServiceImpl implements ProductoService{
	

	private ProductoRepository productoRepository;
	
	public ProductoServiceImpl(ProductoRepository productoRepository) {
		super();
		this.productoRepository = productoRepository;
	}

	@Override
	public List<ProductoDTO> getAllProductos() {
		
		List<ProductoDTO> productosDto = new ArrayList<ProductoDTO>();
		
		List<Producto> productos = productoRepository.findAll();
		ModelMapper modelMapper = new ModelMapper();
		for (Producto producto : productos) {
			
			ProductoDTO productoDto = modelMapper.map(producto, ProductoDTO.class);
			productosDto.add(productoDto);
		}
		
		
		return productosDto;
		
	}

	@Override
	public ProductoDTO getProductoById(Long id) throws Exception {

		ProductoDTO productoDto = null;
		ModelMapper modelMapper = new ModelMapper();
		if (id != 0) {
			
			Producto producto = productoRepository.getById(id);
			
			if (producto != null) {
				productoDto = modelMapper.map(producto, ProductoDTO.class);
			} else {
				throw new ObjectNotFoundException("No existe producto con el id: " + id);
			}
		}else {
			throw new Exception("Id del producto vacío");
		}
		
		return productoDto;
	}


	@Override
	public ProductoDTO deleteProducto(Long id) throws Exception {
		
		ProductoDTO productoDto = null;

		ModelMapper modelMapper = new ModelMapper();
		if (id != null) {
			
			Optional<Producto> opProducto = productoRepository.findById(id);
			
			Producto productoModel = null;
			
			if (opProducto.isPresent()) {
				productoModel = opProducto.get();
				productoModel.setActivo(Boolean.FALSE);
				
				productoModel = productoRepository.save(productoModel);
				productoDto = modelMapper.map(productoModel, ProductoDTO.class);
				
			}else {
				throw new ObjectNotFoundException("Producto con id : " + id  + " , no encontrado");
			}
			
		} else {
			throw new Exception("Producto vacío");
		}
		
		return productoDto;
	}

	@Override
	public ProductoDTO getProductoByOferta(Long idOferta) {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	@Override
	public ProductoDTO saveOrUpdate(ProductoDTO producto) throws Exception {
		
		System.out.println(producto.toString());
		ProductoDTO productoDto = null;
		ModelMapper modelMapper = new ModelMapper();
		
		if (producto != null && producto.getIdCategoria() != null) {
			Producto productoModel = modelMapper.map(producto, Producto.class);
			System.out.println(productoModel.toString()); 
			if(productoModel.isActivo() == false) {
				productoModel.setActivo(Boolean.TRUE);
			}
			
			productoModel = productoRepository.save(productoModel);
			productoDto = modelMapper.map(productoModel, ProductoDTO.class);
			
		}else {
			throw new Exception("Producto vacío");
		}
		
		return productoDto;
	}
	
}
