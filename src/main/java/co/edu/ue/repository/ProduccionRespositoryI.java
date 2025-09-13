package co.edu.ue.repository;

import co.edu.ue.entity.Produccion;

import java.util.List;

public interface ProduccionRespositoryI {
    Produccion createProduccion(Produccion produccion);
    Produccion updateProduccion(Produccion produccion);
    Produccion readProduccion(Integer produccionId);

    List<Produccion> findByUsuarioId(Integer usuarioId);
    List<Produccion> findAll();
    List<Produccion> findAllByUsuarioIdAndProductoId(Integer usuarioId, Integer productoId);
}
