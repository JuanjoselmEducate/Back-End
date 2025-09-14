package co.edu.ue.controller;

import java.util.Date;
import java.util.List;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import co.edu.ue.entity.Gasto;
import co.edu.ue.services.GastoServiceI;

@RestController
@RequestMapping("/api/gastos")
public class GastoController {

    @Autowired
    private GastoServiceI gastoService;

    // Crear gasto
    @PostMapping
    public Gasto crear(@RequestBody Gasto gasto) {
        return gastoService.insertGasto(gasto);
    }

    // Actualizar gasto
    @PutMapping("/{id}")
    public Gasto actualizar(@PathVariable int id, @RequestBody Gasto gasto) {
        gasto.setId(id);
        return gastoService.updateGasto(gasto);
    }

    // Eliminar gasto
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        int result = gastoService.deleteGasto(id);
        return result == 1 ? "Gasto eliminado correctamente" : "No se encontró el gasto con id " + id;
    }

    // Buscar por id
    @GetMapping("/{id}")
    public Gasto buscarPorId(@PathVariable int id) {
        return gastoService.findById(id);
    }

    // Listar todos
    @GetMapping
    public List<Gasto> listar() {
        return gastoService.listAll();
    }

    // Buscar por usuario
    @GetMapping("/usuario/{usuarioId}")
    public List<Gasto> porUsuario(@PathVariable int usuarioId) {
        return gastoService.findByUsuario(usuarioId);
    }

    // Buscar por usuario y rango de fechas
    @GetMapping("/usuario/{usuarioId}/rango")
    public List<Gasto> porUsuarioYRango(
            @PathVariable int usuarioId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fin) {
        return gastoService.findByUsuarioAndFechas(usuarioId, inicio, fin);
    }

    // Total por usuario
    @GetMapping("/usuario/{usuarioId}/total")
    public BigDecimal totalPorUsuario(@PathVariable int usuarioId) {
        return gastoService.totalPorUsuario(usuarioId);
    }
}

