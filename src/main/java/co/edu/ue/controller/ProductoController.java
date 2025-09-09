package co.edu.ue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.services.ProductoServiceI;
import co.edu.ue.services.business_logic.Response;

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
}
