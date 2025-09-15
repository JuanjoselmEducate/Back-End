package co.edu.ue.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import co.edu.ue.entity.MetricasSostenibilidad;
import co.edu.ue.services.MetricasSostenibilidadServiceI;

@RestController
@RequestMapping("/api/metricas")
public class MetricasSostenibilidadController {

    @Autowired
    private MetricasSostenibilidadServiceI service;

    // Crear
    @PostMapping
    public MetricasSostenibilidad crear(@RequestBody MetricasSostenibilidad m) {
        return service.insert(m);
    }

    // Actualizar
    @PutMapping("/{id}")
    public MetricasSostenibilidad actualizar(@PathVariable int id, @RequestBody MetricasSostenibilidad m) {
        m.setId(id);
        return service.update(m);
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        int rows = service.delete(id);
        return rows == 1 ? "Métrica eliminada correctamente" : "No se encontró la métrica con id " + id;
    }

    // Obtener por id
    @GetMapping("/{id}")
    public MetricasSostenibilidad porId(@PathVariable int id) {
        return service.findById(id);
    }

    // Listar todas
    @GetMapping
    public List<MetricasSostenibilidad> listar() {
        return service.listAll();
    }

    // Por usuario
    @GetMapping("/usuario/{usuarioId}")
    public List<MetricasSostenibilidad> porUsuario(@PathVariable int usuarioId) {
        return service.findByUsuario(usuarioId);
    }

    // Por tipo
    @GetMapping("/tipo/{tipo}")
    public List<MetricasSostenibilidad> porTipo(@PathVariable("tipo") String tipoMetrica) {
        return service.findByTipo(tipoMetrica);
    }

    // Por usuario y tipo
    @GetMapping("/usuario/{usuarioId}/tipo")
    public List<MetricasSostenibilidad> porUsuarioYTipo(
            @PathVariable int usuarioId,
            @RequestParam String tipoMetrica) {
        return service.findByUsuarioAndTipo(usuarioId, tipoMetrica);
    }

    // Por usuario y rango de fechas
    @GetMapping("/usuario/{usuarioId}/rango")
    public List<MetricasSostenibilidad> porUsuarioYRango(
            @PathVariable int usuarioId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fin) {
        return service.findByUsuarioAndFechas(usuarioId, inicio, fin);
    }

    // Última por usuario y tipo
    @GetMapping("/usuario/{usuarioId}/ultima")
    public MetricasSostenibilidad ultimaPorUsuarioYTipo(
            @PathVariable int usuarioId,
            @RequestParam String tipoMetrica) {
        return service.findUltimaPorUsuarioYTipo(usuarioId, tipoMetrica);
    }
}
