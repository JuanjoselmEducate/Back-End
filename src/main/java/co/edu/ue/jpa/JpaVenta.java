package co.edu.ue.jpa;

import co.edu.ue.entity.Producto;
import co.edu.ue.entity.Usuario;
import co.edu.ue.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaVenta extends JpaRepository<Venta,Integer> {

    List<Venta> findByUsuarioId(Integer usuarioId);

    List<Venta> findByUsuarioIdAndProductoId(Integer usuarioId, Integer productoId);
}
