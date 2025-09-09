package co.edu.ue.repository;

import java.util.List;

import co.edu.ue.entity.Producto;


public interface ProductoRepositoryI {

	Producto createProducto (Producto producto);
	Producto readProducto (Integer productoId);
	Producto updateProducto (Producto producto);
	
	Producto findbySku(String sku);
	Producto findbyNombreProducto (String nombre);
	
	List<Producto> findbyUsuarioId (Integer usuarioId);
	List<Producto> listProducto();
}
