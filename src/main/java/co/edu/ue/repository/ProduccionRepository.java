package co.edu.ue.repository;


import co.edu.ue.entity.Produccion;
import co.edu.ue.jpa.JpaProduccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProduccionRepository implements ProduccionRespositoryI {

    @Autowired
    private JpaProduccion jpa;

    @Override
    public Produccion createProduccion(Produccion produccion) {
        return jpa.save(produccion);
    }

    @Override
    public Produccion updateProduccion(Produccion produccion) {
        return jpa.save(produccion);
    }

    @Override
    public Produccion readProduccion(Integer produccionId) {
        return jpa.findById(produccionId).orElse(null);
    }

    @Override
    public List<Produccion> findByUsuarioId(Integer usuarioId) {
        return jpa.findAllByUsuarioId(usuarioId);
    }

    @Override
    public List<Produccion> findAll() {
        return jpa.findAll();
    }

    @Override
    public List<Produccion> findAllByUsuarioIdAndProductoId(Integer usuarioId, Integer productoId) {
        return jpa.findByUsuarioIdAndProductoId(usuarioId,productoId);
    }

}
