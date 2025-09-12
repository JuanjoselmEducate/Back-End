package co.edu.ue.repository;

import co.edu.ue.entity.Venta;
import co.edu.ue.jpa.JpaVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VentaRepository implements VentaRepositoryI{

    @Autowired
    private JpaVenta jpa;

    @Override
    public Venta createVenta(Venta venta) {
        return jpa.save(venta);
    }

    @Override
    public Venta readVenta(Integer ventaId) {
        return jpa.findById(ventaId).orElse(null);
    }

    @Override
    public Venta updateVenta(Venta venta) {
        return jpa.save(venta);
    }

    @Override
    public List<Venta> findAllByUsuarioId(Integer usuarioId) {
        return jpa.findByUsuarioId(usuarioId);
    }

    @Override
    public List<Venta> findByUsuarioIdAndProductoId(Integer usuarioId, Integer productoId) {
        return jpa.findByUsuarioIdAndProductoId(usuarioId, productoId);
    }

    @Override
    public List<Venta> lisVentas() {
        return jpa.findAll();
    }
}
