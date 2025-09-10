package co.edu.ue.controller;

import co.edu.ue.services.business_logic.createI.ProductoCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.entity.Producto;
import co.edu.ue.services.ProductoServiceI;
import co.edu.ue.services.business_logic.Response;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value="/api/productos")
public class ProductoController {
	
	@Autowired
	private ProductoServiceI ser;
	
	@GetMapping
	public Response getAllProductos() {
		return ser.listProducto();
	}
	
	@GetMapping("/{id}")
	public Response getById(@PathVariable Integer id) {
		return ser.readProducto(id);
	}
	
	@PostMapping
	public Response postCreateProducto(@RequestBody ProductoCreate producto) {
		return ser.createProducto(producto);
	}
	
	@PutMapping("/{id}")
	public Response putUpdateProducto(@PathVariable Integer id, @RequestBody ProductoCreate producto) {
		return ser.updateProducto(id, producto);
	}
	
	@DeleteMapping("/{id}")
	public Response disableProducto(@PathVariable Integer id) {
		return ser.disableProducto(id);
	}
	
	@GetMapping("/sku/{sku}")
	public Response getProductoBySku(@PathVariable String sku) {
		return ser.readProductoBySku(sku);
	}
	
	@GetMapping("/nombre/{nombre}")
	public Response getProductoByNombre(@PathVariable String nombre) {
		return ser.readProductoByNombre(nombre);
	}
	
	@GetMapping("/usuario/{id}")
	public Response getProductoByUsuarioId (@PathVariable Integer id) {
		return ser.listProductoByUsuarioId(id);
	}
	
	
	
}
