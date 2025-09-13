package co.edu.ue.jpa;

import co.edu.ue.entity.Produccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaProduccion extends JpaRepository<Produccion, Integer> {
    List<Produccion> findAllByUsuarioId (Integer usuarioId);
    List<Produccion> findByUsuarioIdAndProductoId(Integer usuarioId, Integer productoId);
}
