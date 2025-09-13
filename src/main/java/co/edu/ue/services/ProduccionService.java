package co.edu.ue.services;

import co.edu.ue.entity.Produccion;
import co.edu.ue.entity.Producto;
import co.edu.ue.entity.Usuario;
import co.edu.ue.repository.ProduccionRespositoryI;
import co.edu.ue.repository.ProductoRepositoryI;
import co.edu.ue.repository.UsuarioRepositoryI;
import co.edu.ue.services.business_logic.Response;
import co.edu.ue.services.business_logic.create.ProduccionCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class ProduccionService implements ProduccionServiceI {

    @Autowired
    ProduccionRespositoryI rep;

    @Autowired
    UsuarioRepositoryI repUsuario;

    @Autowired
    ProductoRepositoryI repProducto;

    @Override
    public Response createProduccion(ProduccionCreate produccionCreate) {
        Response response = new Response();
        Timestamp timeNow = Timestamp.from(Instant.now());
        Usuario usuario = repUsuario.readUsuario(produccionCreate.getUsuarioId());
        if (usuario == null) {
            return response.buildResponse("Usuario no encontrado.", 409);
        }
        Producto producto = repProducto.readProducto(produccionCreate.getProductoId());
        if (producto == null) {
            return response.buildResponse("Producto no encontrado.", 409);
        }
        try {
            Produccion produccion = new Produccion();
            produccion.setCantidadProducida(produccionCreate.getCantidadProducida());
            produccion.setFechaProduccion(produccionCreate.getFechaProduccion());
            produccion.setCostoProduccion(produccionCreate.getCostoProduccion());
            produccion.setCantidadDesperdicio(produccionCreate.getCantidadDesperdicio());
            produccion.setCostoDesperdicio(produccionCreate.getCostoDesperdicio());
            produccion.setPorcentajeEficiencia(produccionCreate.getPorcentajeEficiencia());
            produccion.setNotas(produccionCreate.getNotas());
            produccion.setCreado(timeNow);
            produccion.setProducto(producto);
            produccion.setUsuario(usuario);
            rep.createProduccion(produccion);
            return response.buildResponse("Produccion cargada con exito.", 201);
        } catch (Exception e) {
            return response.buildResponse("Error al crear la produccion: " + e.getMessage(), 500);
        }
    }

    @Override
    public Response updateProduccion(Integer Id, ProduccionCreate produccionCreate) {
        Response response = new Response();
        Produccion existing = rep.readProduccion(Id);

        if (produccionCreate.getUsuarioId() != null){
            Usuario usuario = repUsuario.readUsuario(produccionCreate.getUsuarioId());
            if (usuario == null) {
                return response.buildResponse("Usuario no encontrado.", 409);
            }
            existing.setUsuario(usuario);
        }
        if (produccionCreate.getProductoId() != null){
            Producto producto = repProducto.readProducto(produccionCreate.getProductoId());
            if (producto == null) {
                return response.buildResponse("Producto no encontrado.", 409);
            }
            existing.setProducto(producto);
        }
        if (existing == null) {
            return response.buildResponse("Produccion no encontrada.", 404);
        }

        if (produccionCreate.getCantidadProducida() != null) {
            existing.setCantidadProducida(produccionCreate.getCantidadProducida());
        }
        if (produccionCreate.getFechaProduccion() != null) {
            existing.setFechaProduccion(produccionCreate.getFechaProduccion());
        }
        if (produccionCreate.getCostoProduccion() != null) {
            existing.setCostoProduccion(produccionCreate.getCostoProduccion());
        }
        if (produccionCreate.getCantidadDesperdicio() != null) {
            existing.setCantidadDesperdicio(produccionCreate.getCantidadDesperdicio());
        }
        if (produccionCreate.getCostoDesperdicio() != null) {
            existing.setCostoDesperdicio(produccionCreate.getCostoDesperdicio());
        }
        if (produccionCreate.getPorcentajeEficiencia() != null) {
            existing.setPorcentajeEficiencia(produccionCreate.getPorcentajeEficiencia());
        }
        if (produccionCreate.getNotas() != null) {
            existing.setNotas(produccionCreate.getNotas());
        }
        try {
            rep.updateProduccion(existing);
            return response.buildResponse("Produccion actualizada con exito.", 200);
        } catch (Exception e) {
            return response.buildResponse("Error al actualizar la produccion: " + e.getMessage(), 500);
        }
    }

    @Override
    public Response readProduccion(Integer produccionId) {
        Response response = new Response();
        Produccion produccion = rep.readProduccion(produccionId);
        if (produccion == null) {
            return response.buildResponse("Produccion no encontrada.", 404);
        }
        return response.buildResponse(produccion, 200);
    }

    @Override
    public Response findAll() {
        Response response = new Response();
        List<Produccion> producciones = rep.findAll();
        if (producciones == null) {
            return  response.buildResponse("No se encontraron registros de produccion.", 409);
        }
        return response.buildResponse(producciones, 200);
    }

    @Override
    public Response findAllByUsuarioId(Integer usuarioId) {
        Response response = new Response();
        List<Produccion> producciones = rep.findByUsuarioId(usuarioId);
        if (producciones == null || producciones.isEmpty()) {
            return response.buildResponse("No se encontraron registros de produccion para el usuario.", 409);
        }
        return response.buildResponse(producciones, 200);
    }

    @Override
    public Response findAllByUsuarioIdAndProductoId(Integer usuarioId, Integer productoId) {
        Response response = new Response();
        List<Produccion> producciones = rep.findAllByUsuarioIdAndProductoId(usuarioId, productoId);
        if (producciones == null || producciones.isEmpty()) {
            return response.buildResponse("No se encontraron registros de produccion para el usuario y producto.", 409);
        }
        return response.buildResponse(producciones, 200);
    }
}
