package co.edu.ue.services;

import co.edu.ue.entity.Producto;
import co.edu.ue.services.business_logic.Response;
import co.edu.ue.services.business_logic.createI.ProductoCreate;

public interface ProductoServiceI {

	Response createProducto (ProductoCreate producto);
	Response readProducto (Integer productoId);
	Response updateProducto (Integer id, ProductoCreate producto);
	Response disableProducto (Integer id);
	
	Response readProductoBySku(String sku);
	Response readProductoByNombre(String noombre);
	
	Response listProducto();
	Response listProductoByUsuarioId(Integer usuarioId);
}
