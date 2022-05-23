package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.dto.ProductoDTO;

public interface ProductoService {
	
	public List<ProductoDTO> getAllProductos();
	public ProductoDTO getProductoById(Long id) throws Exception;
	public ProductoDTO getProductoByOferta(Long id_Oferta);
	public ProductoDTO deleteProducto(Long id) throws Exception;
	public ProductoDTO saveOrUpdate(ProductoDTO producto) throws Exception;
}
