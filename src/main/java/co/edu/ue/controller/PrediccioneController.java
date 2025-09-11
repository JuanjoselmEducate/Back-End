package co.edu.ue.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import co.edu.ue.entity.Prediccione;
import co.edu.ue.services.PrediccioneServiceI;

@RestController
@RequestMapping("/api/predicciones")
public class PrediccioneController {

    @Autowired
    private PrediccioneServiceI service;

    // Crear
    @PostMapping
    public Prediccione crear(@RequestBody Prediccione pred) {
        return service.insertPrediccion(pred);
    }

    // Actualizar
    @PutMapping("/{id}")
    public Prediccione actualizar(@PathVariable int id, @RequestBody Prediccione pred) {
        pred.setId(id);
        return service.updatePrediccion(pred);
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        int rows = service.deletePrediccion(id);
        return rows == 1 ? "Predicción eliminada correctamente"
                         : "No se encontró la predicción con id " + id;
    }

    // Obtener por id
    @GetMapping("/{id}")
    public Prediccione buscarPorId(@PathVariable int id) {
        return service.findById(id);
    }

    // Listar todas
    @GetMapping
    public List<Prediccione> listar() {
        return service.listAll();
    }

    // Por usuario
    @GetMapping("/usuario/{usuarioId}")
    public List<Prediccione> porUsuario(@PathVariable int usuarioId) {
        return service.findByUsuario(usuarioId);
    }

    // Por producto (si aún no tienes producto, comenta este endpoint)
    /*@GetMapping("/producto/{productoId}")
    public List<Prediccione> porProducto(@PathVariable int productoId) {
        return service.findByProducto(productoId);
    }*/

    // Por tipo
    @GetMapping("/tipo/{tipo}")
    public List<Prediccione> porTipo(@PathVariable("tipo") String tipoPrediccion) {
        return service.findByTipo(tipoPrediccion);
    }

    // Por usuario y tipo
    @GetMapping("/usuario/{usuarioId}/tipo")
    public List<Prediccione> porUsuarioYTipo(
            @PathVariable int usuarioId,
            @RequestParam String tipoPrediccion) {
        return service.findByUsuarioAndTipo(usuarioId, tipoPrediccion);
    }

    // Por usuario y rango de fechas
    @GetMapping("/usuario/{usuarioId}/rango")
    public List<Prediccione> porUsuarioYRango(
            @PathVariable int usuarioId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fin) {
        return service.findByUsuarioAndFechas(usuarioId, inicio, fin);
    }

    // Por período objetivo (ej: 2025-09 o 2025-Q1)
    @GetMapping("/periodo/{periodoObjetivo}")
    public List<Prediccione> porPeriodo(@PathVariable String periodoObjetivo) {
        return service.findByPeriodoObjetivo(periodoObjetivo);
    }

    // Última por usuario y producto
    @GetMapping("/usuario/{usuarioId}/ultimo")
    public Prediccione ultimaPorUsuarioYProducto(
            @PathVariable int usuarioId,
            @RequestParam int productoId) {
        return service.findUltimaPorUsuarioYProducto(usuarioId, productoId);
    }
}
