package co.edu.ue.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.entity.Gasto;
import co.edu.ue.services.GastoService;

@RestController
@RequestMapping("/api/gastos")
@CrossOrigin // permite llamadas desde el front
public class GastoController {

    private final GastoService service;

    public GastoController(GastoService service) {
        this.service = service;
    }

    // ===== CRUD =====
    @GetMapping
    public List<Gasto> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public Gasto obtener(@PathVariable int id) { return service.obtener(id); }

    // Enviar userId y categoriaId como query params (?userId=1&categoriaId=2)
    @PostMapping
    public Gasto crear(@RequestBody Gasto gasto,
                       @RequestParam int userId,
                       @RequestParam int categoriaId) {
        return service.crear(gasto, userId, categoriaId);
    }

    @PutMapping("/{id}")
    public Gasto actualizar(@PathVariable int id,
                            @RequestBody Gasto gasto,
                            @RequestParam int userId,
                            @RequestParam int categoriaId) {
        return service.actualizar(id, gasto, userId, categoriaId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // ===== Consultas extra =====
    @GetMapping("/usuario/{userId}")
    public List<Gasto> porUsuario(@PathVariable int userId) {
        return service.porUsuario(userId);
    }

    @GetMapping("/categoria/{categoriaId}")
    public List<Gasto> porCategoria(@PathVariable int categoriaId) {
        return service.porCategoria(categoriaId);
    }

    @GetMapping("/tipo/{tipo}")
    public List<Gasto> porTipo(@PathVariable String tipo) {
        return service.porTipo(tipo);
    }

    // Fechas en formato YYYY-MM-DD
    @GetMapping("/rango/{inicio}/{fin}")
    public List<Gasto> porRango(@PathVariable String inicio,
                                @PathVariable String fin) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = sdf.parse(inicio);
        Date d2 = sdf.parse(fin);
        return service.porRango(d1, d2);
    }
}
