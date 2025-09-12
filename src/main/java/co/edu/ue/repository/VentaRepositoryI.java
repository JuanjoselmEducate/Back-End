package co.edu.ue.repository;

import co.edu.ue.entity.Venta;

import java.util.List;

public interface VentaRepositoryI {
    Venta createVenta(Venta venta);
    Venta readVenta(Integer ventaId);
    Venta updateVenta(Venta venta);

    List<Venta> findAllByUsuarioId(Integer usuarioId);
    List<Venta> findByUsuarioIdAndProductoId(Integer usuarioId, Integer productoId);

    List<Venta> lisVentas();
}
