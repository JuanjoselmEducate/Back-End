package co.edu.ue.services;

import co.edu.ue.services.business_logic.Response;
import co.edu.ue.services.business_logic.create.ProductoCreate;
import co.edu.ue.services.business_logic.create.VentaCreate;

public interface VentaServiceI {
    Response createVenta (VentaCreate venta);
    Response readVenta (Integer ventaId);
    Response updateVenta (Integer id, VentaCreate ventaCreate);

    Response findByUsuarioId(Integer usuarioId);
    Response findByUsuarioIdAndProductoId(Integer usuarioId, Integer productoId);

    Response listVentas();

}
