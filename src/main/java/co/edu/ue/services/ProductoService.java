package co.edu.ue.services;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import co.edu.ue.entity.Categoria;
import co.edu.ue.entity.Usuario;
import co.edu.ue.repository.CategoriaRepositoryI;
import co.edu.ue.repository.UsuarioRepositoryI;
import co.edu.ue.services.business_logic.create.ProductoCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.entity.Producto;
import co.edu.ue.repository.ProductoRepositoryI;
import co.edu.ue.services.business_logic.Response;

@Service
public class ProductoService implements ProductoServiceI{

	@Autowired
	ProductoRepositoryI rep;

    @Autowired
    UsuarioRepositoryI repUsuario;

    @Autowired
    CategoriaRepositoryI repCategoria;
	
	@Override
	public Response createProducto(ProductoCreate productoCreate) {
	    Response response = new Response();
        Timestamp timeNow = Timestamp.from(Instant.now());

        if (rep.findbySku(productoCreate.getSku()) != null) {
            return response.buildResponse("Ya existe un producto con este SKU", 409);
        }

        if (rep.findbyNombreProducto(productoCreate.getNombre()) != null) {
            return response.buildResponse("Ya existe un producto con este nombre", 409);
        }

        Usuario usuario = repUsuario.readUsuario( (int) productoCreate.getUsuario_id());
        if (usuario == null) {
            return response.buildResponse("Usuario no encontrado", 409);
        }

        Categoria categoria = repCategoria.readCategoria(productoCreate.getCategoria_id());
        if (categoria == null) {
            return response.buildResponse("Categoria no encontrada", 409);
        }
        Producto producto = new Producto();
        producto.setUsuario(usuario);
        producto.setCategoria(categoria);
        producto.setNombreProducto(productoCreate.getNombre());
        producto.setDescripcion(productoCreate.getDescripcion());
        producto.setPrecioUnitario( new BigDecimal(productoCreate.getPrecioUnitario()));
        producto.setCostoPorUnidad( new BigDecimal(productoCreate.getCostoPorUnidad()));
        producto.setSku(productoCreate.getSku());
        producto.setEstado((byte)1);
        producto.setCreado(timeNow);
        producto.setActualizado(timeNow);
	    try {
	        rep.createProducto(producto);
	        return response.buildResponse("Producto creado con éxito", 201);
	    } catch (Exception e) {
	        return response.buildResponse("Error al crear el producto: " + e.getMessage(), 500);
	    }
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
        	response.buildResponse(producto, status);
        }
        return response;
	}

	@Override
	public Response updateProducto(Integer id, ProductoCreate producto) {
	    Response response = new Response();

	    Producto productoExistente = rep.readProducto(id);
	    if (productoExistente == null) {
	        return response.buildResponse("Producto no encontrado", 404);
	    }
	    
	    if (producto.getSku() != null && !producto.getSku().equals(productoExistente.getSku())) {
	        Producto productoSku = rep.findbySku(producto.getSku());
	        if (productoSku != null) {
	            return response.buildResponse("El SKU ya está en uso por otro producto", 409);
	        }
	    }
	    
	    if (producto.getNombre() != null && !producto.getNombre().equals(productoExistente.getNombreProducto())) {
	        Producto productoNombre = rep.findbyNombreProducto(producto.getNombre());
	        if (productoNombre != null) {
	            return response.buildResponse("El nombre ya está en uso por otro producto", 409);
	        }
	    }
	    
	    if (producto.getNombre() != null) {
	        productoExistente.setNombreProducto(producto.getNombre());
	    }
	    if (producto.getDescripcion() != null) {
	        productoExistente.setDescripcion(producto.getDescripcion());
	    }
	    if (producto.getPrecioUnitario() != null) {
	        productoExistente.setPrecioUnitario( new BigDecimal(producto.getPrecioUnitario()));
	    }
	    if (producto.getCostoPorUnidad() != null) {
	        productoExistente.setCostoPorUnidad( new BigDecimal(producto.getCostoPorUnidad()));
	    }
	    if (producto.getSku() != null) {
	        productoExistente.setSku(producto.getSku());
	    }

	    productoExistente.setActualizado(Timestamp.from(Instant.now()));
	    
	    productoExistente.setCreado(productoExistente.getCreado());
	    
	    try {
	        Producto productoActualizado = rep.updateProducto(productoExistente);
	        return response.buildResponse("Producto actualizado exitosamente", 200);
	    } catch (Exception e) {
	        return response.buildResponse("Error al actualizar el producto: " + e.getMessage(), 500);
	    }
	}

	@Override
	public Response disableProducto(Integer id) {
	    Response response = new Response();
	    Producto producto = rep.readProducto(id);
	    if (producto != null) {
	        producto.setEstado((byte)0); 
	        producto.setActualizado(Timestamp.from(Instant.now()));	        
	        try {
	            rep.updateProducto(producto);
	            return response.buildResponse("Producto desactivado exitosamente", 200);
	        } catch (Exception e) {
	            return response.buildResponse("Error al desactivar el producto:" + e.getMessage(), 500);
	        }
	    } else {
	        return response.buildResponse("Producto no encontrado", 404);
	    }
	}

	@Override
	public Response readProductoBySku(String sku) {
	    Response response = new Response();
	    
	    Producto producto = rep.findbySku(sku);
	    if (producto != null) {
	        return response.buildResponse(producto, 200);
	    } else {
	        return response.buildResponse("Producto no encontrado con SKU: " + sku, 404);
	    }
	}

	@Override
	public Response readProductoByNombre(String nombre) {
	    Response response = new Response();
	    
	    Producto producto = rep.findbyNombreProducto(nombre);
	    if (producto != null) {
	        return response.buildResponse(producto, 200);
	    } else {
	        return response.buildResponse("Producto no encontrado con nombre: " + nombre, 404);
	    }
	}

	@Override
	public Response listProductoByUsuarioId(Integer usuarioId) {
	    Response response = new Response();
	    if(repUsuario.readUsuario(usuarioId) == null) {
            return response.buildResponse("Usuario no encontrado", 404);
        }
	    List<Producto> productos = rep.findbyUsuarioId(usuarioId);
	    if (productos != null && !productos.isEmpty()) {
	        return response.buildResponse(productos, 200);
	    } else {
	        return response.buildResponse("No se encontraron productos para el usuario", 404);
	    }
	}

	@Override
	public Response listProducto() {
	    Response response = new Response();
	    
	    List<Producto> productos = rep.listProducto(); 
	    if (productos != null && !productos.isEmpty()) {
	        return response.buildResponse(productos, 200);
	    } else {
	        return response.buildResponse("No se encontraron productos", 404);
	    }
	}

}
