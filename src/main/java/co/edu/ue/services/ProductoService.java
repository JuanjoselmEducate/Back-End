package co.edu.ue.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.entity.Producto;
import co.edu.ue.repository.ProductoRepositoryI;
import co.edu.ue.services.business_logic.Response;

@Service
public class ProductoService implements ProductoServiceI{

	@Autowired
	ProductoRepositoryI rep;
	
	@Override
	public Response createProducto(Producto producto) {
		Response response = new Response();
		String message = "";
		Integer status = 400;
		if(rep.findbyNombreProducto(producto.getNombreProducto()) == null && rep.findbySku(producto.getSku()) == null) {
			rep.createProducto(producto);
			message = "Producto creado con exito!";
			status = 201;
		}else {
			message = "No se pudo crear el produto";
		}	
		return response.buildResponse(message, status);
	}

	@Override
	public Response readProducto(Integer productoId) {
        Response response = new Response();
        Integer status = 0;
        Producto producto = rep.readProducto(productoId);
        if(producto == null) {
        	String message = "Producto no encontrado.";
        	status = 404;
        	response.buildResponse(message, status);
        }else {
        	Producto message = producto;
        	status = 200;
        	response.buildResponse(message, status);
        }
        return response;
	}

	@Override
	public Response updateProducto(Integer id, Producto producto) {
		Response response = new Response();
		String message = "";
		Integer status = 0;
		if(!(rep.readProducto(id) == null)) {
			
		}else {
			message = "Producto no encontrado";
			status = 404;
		}
		return response.buildResponse(message, status);
	}

	@Override
	public Response disableProducto(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response readProductoBySku(String sku) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response readProductoByNombre(String noombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response listProducto() {
		Response response = new Response();
		List<Producto> productos = rep.listProducto(); 
		if(productos != null) {
			response.buildResponse(productos, 200);
		}else {
			response.buildResponse("Productos no encontrados.", 404);
		}
		return response;
	}

	@Override
	public Response listProductoByUsuarioId(Integer usuarioId) {
		// TODO Auto-generated method stub
		return null;
	}

}
