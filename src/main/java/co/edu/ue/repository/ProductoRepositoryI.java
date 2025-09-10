package co.edu.ue.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;

import co.edu.ue.entity.Producto;


public interface ProductoRepositoryI {

	Producto createProducto (Producto producto);
	Producto readProducto (Integer productoId);
	Producto updateProducto (Producto producto);
	
	Producto findbySku(String sku);
	Producto findbyNombreProducto (String nombre);
	
	List<Producto> findbyUsuarioId (Integer usuarioId);
	
	@EntityGraph(attributePaths = {"categoria"})
	List<Producto> listProducto();
}
