package co.edu.ue.controller;

import co.edu.ue.entity.Venta;
import co.edu.ue.services.VentaServiceI;
import co.edu.ue.services.business_logic.Response;
import co.edu.ue.services.business_logic.create.VentaCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/ventas")
public class VentaController {

    @Autowired
    VentaServiceI ser;

    @GetMapping
    public Response getAllVentas(){
        return ser.listVentas();
    }

    @GetMapping("/{id}")
    public Response getVenta(@PathVariable Integer id){
        return ser.readVenta(id);
    }

    @PostMapping
    public Response createVenta(@RequestBody VentaCreate venta){
        return ser.createVenta(venta);
    }

    @PutMapping("/{id}")
    public Response updateVenta(@PathVariable Integer id, @RequestBody VentaCreate venta){
        return ser.updateVenta(id, venta);
    }

    @GetMapping("/usuario/{id}")
    public Response getVentasByUsuario(@PathVariable Integer id){
        return ser.findByUsuarioId(id);
    }

    @GetMapping("/usuario/{usuarioId}/producto/{productoId}")
    public Response getVentasByUsuarioAndProducto(@PathVariable Integer usuarioId, @PathVariable Integer productoId){
        return ser.findByUsuarioIdAndProductoId(usuarioId, productoId);
    }
}
