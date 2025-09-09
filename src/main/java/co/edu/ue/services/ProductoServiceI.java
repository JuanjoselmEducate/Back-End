package co.edu.ue.services;

import co.edu.ue.entity.Producto;
import co.edu.ue.services.business_logic.Response;

public interface ProductoServiceI {

	Response createProducto (Producto producto);
	Response readProducto (Integer productoId);
	Response updateProducto (Integer id, Producto producto);
	Response disableProducto (Integer id);
	
	Response readProductoBySku(String sku);
	Response readProductoByNombre(String noombre);
	
	Response listProducto();
	Response listProductoByUsuarioId(Integer usuarioId);
}
