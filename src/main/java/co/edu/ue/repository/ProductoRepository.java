package co.edu.ue.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Producto;
import co.edu.ue.jpa.JpaProducto;

@Repository
public class ProductoRepository implements ProductoRepositoryI
{

	@Autowired
	JpaProducto jpa;

	@Override
	public Producto createProducto(Producto producto) {
		return jpa.save(producto);
	}

	@Override
	public Producto readProducto(Integer productoId) {
		return jpa.findById(productoId).orElse(null);
	}

	@Override
	public Producto updateProducto(Producto producto) {
		return jpa.save(producto);
	}

	@Override
	public Producto findbySku(String sku) {
		return jpa.findBySku(sku);
	}

	@Override
	public List<Producto> listProducto() {
		return jpa.findAll();
	}

	@Override
	public List<Producto> findbyUsuarioId(Integer id) {
		return jpa.findByUsuarioId(id);
	}

	@Override
	public Producto findbyNombreProducto(String nombre) {
		return jpa.findByNombreProducto(nombre);
	}
	


}
