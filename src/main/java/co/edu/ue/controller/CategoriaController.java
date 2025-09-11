package co.edu.ue.controller;

import co.edu.ue.services.CategoriaServiceI;
import co.edu.ue.services.business_logic.Response;
import co.edu.ue.services.business_logic.create.CategoriaCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/categorias")
class CategoriaController {

    @Autowired
    CategoriaServiceI ser;

    @GetMapping
    public Response getAllCategorias() {
        return ser.listCategorias();
    }

    @PostMapping
    public Response createCategoria (@RequestBody CategoriaCreate categoria) {
        return ser.createCategoria(categoria);
    }

    @GetMapping(value = "/{id}")
    public Response getCategoriaById(@PathVariable Integer id) {
        return ser.readCategoria(id);
    }

    @PutMapping(value = "/{id}")
    public Response putActualizarCategoria(@PathVariable Integer id, @RequestBody CategoriaCreate categoria) {
        return ser.updateCategoria(id,categoria);
    }

    @GetMapping(value = "/usuario/{id}/tipo/{tipo}")
    public Response getTipoCategoria(@PathVariable Integer id, @PathVariable String tipo) {
        return ser.findByTipo(tipo, id);
    }

    @GetMapping(value="/usuario/{id}/nombre/{nombre}")
    public Response getNombreCategoria(@PathVariable Integer id, @PathVariable String nombre) {
        return ser.findByNombre(nombre, id);
    }

    @GetMapping(value = "/usuario/{id}")
    public Response getUsuarioCategoria(@PathVariable Integer id) {
        return ser.listFindByUsuarioId(id);
    }
}
