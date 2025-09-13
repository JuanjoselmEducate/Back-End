package co.edu.ue.controller;

import co.edu.ue.services.ProduccionServiceI;
import co.edu.ue.services.business_logic.Response;
import co.edu.ue.services.business_logic.create.ProduccionCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produccion")
public class ProduccionController {

    @Autowired
    ProduccionServiceI ser;

    @GetMapping
    public Response getAllProducciones() {
        return ser.findAll();
    }

    @GetMapping("/{id}")
    public Response getProduccionById(@PathVariable Integer id) {
        return ser.readProduccion(id);
    }

    @PostMapping
    public Response createProduccion(@RequestBody ProduccionCreate produccionCreate) {
        return ser.createProduccion(produccionCreate);
    }

    @PutMapping("/{id}")
    public Response updateProduccion(@PathVariable Integer id, @RequestBody ProduccionCreate produccionCreate) {
        return ser.updateProduccion(id, produccionCreate);
    }

    @GetMapping("/usuario/{usuarioId}")
    public Response getProduccionesByUsuario(@PathVariable Integer usuarioId) {
        return ser.findAllByUsuarioId(usuarioId);
    }

    @GetMapping("/usuario/{usuarioId}/producto/{productoId}")
    public Response getProduccionesByUsuarioAndProducto(@PathVariable Integer usuarioId, @PathVariable Integer productoId) {
        return ser.findAllByUsuarioIdAndProductoId(usuarioId, productoId);
    }
}

