package co.edu.ue.services;

import co.edu.ue.entity.Producto;
import co.edu.ue.entity.Usuario;
import co.edu.ue.entity.Venta;
import co.edu.ue.repository.CategoriaRepositoryI;
import co.edu.ue.repository.ProductoRepositoryI;
import co.edu.ue.repository.UsuarioRepositoryI;
import co.edu.ue.repository.VentaRepository;
import co.edu.ue.services.business_logic.Response;
import co.edu.ue.services.business_logic.create.VentaCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService implements VentaServiceI{

    @Autowired
    VentaRepository rep;

    @Autowired
    UsuarioRepositoryI repUsuario;

    @Autowired
    ProductoRepositoryI repProducto;


    @Override
    public Response createVenta(VentaCreate ventaCreate) {
        Response response = new Response();
        Venta venta = new Venta();
        Usuario usuario = repUsuario.readUsuario(ventaCreate.getUsuarioId());
        Timestamp timeNow = Timestamp.from(Instant.now());
        if (usuario == null) {
            return response.buildResponse("Usuario no encontrado.", 409);
        }
        Producto producto = repProducto.readProducto(ventaCreate.getProductoId());
        if (producto == null) {
            return response.buildResponse("Producto no encontrado.", 409);
        }
        venta.setUsuario(usuario);
        venta.setProducto(producto);
        venta.setCantidad(ventaCreate.getCantidad());
        venta.setPrecioUnitario(ventaCreate.getPrecioUnitario());
        venta.setMontoTotal(ventaCreate.getMontoTotal());
        venta.setFechaVenta(ventaCreate.getFechaVenta());
        venta.setNombreCliente(ventaCreate.getNombreCliente());
        venta.setNotas(ventaCreate.getNotas());
        venta.setCreado(timeNow);
        try {
            rep.createVenta(venta);
            return response.buildResponse("Venta creada con éxito", 201);
        } catch (Exception e) {
            return response.buildResponse("Error al crear la venta: " + e.getMessage(), 500);
        }
    }

    @Override
    public Response readVenta(Integer ventaId) {
        Response response = new Response();
        Venta venta = rep.readVenta(ventaId);
        if (venta == null) return response.buildResponse("Venta no existente.", 404);
        return response.buildResponse(venta, 200);
    }

    @Override
    public Response updateVenta(Integer id,VentaCreate ventaCreate) {
        Response response = new Response();
        Venta venta = rep.readVenta(id);
        if (venta == null) return response.buildResponse("Venta no existente.", 404);
        if(ventaCreate.getUsuarioId() != null){
            Usuario usuario = repUsuario.readUsuario(id);
            if(usuario==null){
                return response.buildResponse("Usuario no encontrado.", 404);
            }
            venta.setUsuario(usuario);
        }
        if(ventaCreate.getProductoId() != null){
            Producto producto = repProducto.readProducto(ventaCreate.getProductoId());
            if(producto==null){
                return response.buildResponse("Producto no encontrado.", 404);
            }
            venta.setProducto(producto);
        }else{
            venta.setProducto(venta.getProducto());
        }
        if (ventaCreate.getCantidad() != null){
            venta.setCantidad(ventaCreate.getCantidad());
        }
        if(ventaCreate.getPrecioUnitario() != null){
            venta.setPrecioUnitario(ventaCreate.getPrecioUnitario());
        }
        if(ventaCreate.getMontoTotal() != null){
            venta.setMontoTotal(ventaCreate.getMontoTotal());
        }
        if(ventaCreate.getFechaVenta() != null){
            venta.setFechaVenta(ventaCreate.getFechaVenta());
        }
        if(ventaCreate.getNombreCliente() != null){
            venta.setNombreCliente(ventaCreate.getNombreCliente());
        }
        if(ventaCreate.getNotas() != null){
            venta.setNotas(ventaCreate.getNotas());
        }
        try {
            rep.updateVenta(venta);
            return response.buildResponse("Venta actualizada con éxito", 201);
        } catch (Exception e) {
            return response.buildResponse("Error al actualizar la venta: " + e.getMessage(), 500);
        }
    }

    @Override
    public Response findByUsuarioId(Integer usuarioId) {
        Response response = new Response();
        Usuario usuario = repUsuario.readUsuario(usuarioId);
        if (usuario == null) return response.buildResponse("Usuario no encontrado", 409);
        List<Venta> ventas = rep.findAllByUsuarioId(usuarioId);
        if (ventas == null) return response.buildResponse("No encontrado ventas.", 409);
        return response.buildResponse(ventas, 200);
    }

    @Override
    public Response findByUsuarioIdAndProductoId(Integer usuarioId, Integer productoId) {
        Response response = new Response();
        Usuario usuario = repUsuario.readUsuario(usuarioId);
        if (usuario == null) return response.buildResponse("Usuario no encontrado", 409);
        Producto producto = repProducto.readProducto(productoId);
        if (producto == null) return response.buildResponse("Producto no encontrado.", 409);
        List<Venta> ventas = rep.findByUsuarioIdAndProductoId(usuarioId, productoId);
        return response.buildResponse(ventas, 200);
    }

    @Override
    public Response listVentas() {
        Response response = new Response();
        List<Venta> ventas = rep.lisVentas();
        if (ventas != null) {
            return response.buildResponse(ventas, 200);
        }
        return response.buildResponse("No se encontraron ventas.", 409);
    }
}
