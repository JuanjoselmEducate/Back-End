package co.edu.ue.services;

import co.edu.ue.entity.Produccion;
import co.edu.ue.services.business_logic.Response;
import co.edu.ue.services.business_logic.create.ProduccionCreate;

import java.util.List;

public interface ProduccionServiceI {
    Response createProduccion(ProduccionCreate produccionCreate);
    Response updateProduccion(Integer id, ProduccionCreate produccionCreate);
    Response readProduccion(Integer produccionId);

    Response findAll();
    Response findAllByUsuarioId (Integer usuarioId);
    Response findAllByUsuarioIdAndProductoId(Integer usuarioId, Integer productoId);
}
