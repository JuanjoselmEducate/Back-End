package co.edu.ue.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.entity.Producto;
import co.edu.ue.entity.Usuario;

public interface JpaProducto extends JpaRepository<Producto, Integer> {
	Producto findBySku (String sku);
	Producto findByNombreProducto (String nombreProducto);
	List<Producto> findByUsuarioId (Integer usuarioId);
}
