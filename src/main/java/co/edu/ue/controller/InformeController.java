package co.edu.ue.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import co.edu.ue.entity.Informe;
import co.edu.ue.services.InformeServiceI;

@RestController
@RequestMapping("/api/informes")
public class InformeController {

    @Autowired
    private InformeServiceI informeService;

    // Crear informe
    @PostMapping
    public Informe crear(@RequestBody Informe informe) {
        return informeService.insertInforme(informe);
    }

    // Actualizar informe
    @PutMapping("/{id}")
    public Informe actualizar(@PathVariable int id, @RequestBody Informe informe) {
        informe.setId(id);
        return informeService.updateInforme(informe);
    }

    // Eliminar informe
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        int result = informeService.deleteInforme(id);
        return result == 1 ? "Informe eliminado correctamente"
                           : "No se encontró el informe con id " + id;
    }

    // Buscar por id
    @GetMapping("/{id}")
    public Informe buscarPorId(@PathVariable int id) {
        return informeService.findById(id);
    }

    // Listar todos
    @GetMapping
    public List<Informe> listar() {
        return informeService.listAll();
    }

    // Listar por usuario
    @GetMapping("/usuario/{usuarioId}")
    public List<Informe> porUsuario(@PathVariable int usuarioId) {
        return informeService.findByUsuario(usuarioId);
    }

    // Listar por tipo de informe
    @GetMapping("/tipo/{tipo}")
    public List<Informe> porTipo(@PathVariable("tipo") String tipoInforme) {
        return informeService.findByTipo(tipoInforme);
    }

    // Listar por usuario y periodo (inicio/fin)
    @GetMapping("/usuario/{usuarioId}/periodo")
    public List<Informe> porUsuarioYPeriodo(
            @PathVariable int usuarioId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fin) {
        return informeService.findByUsuarioAndPeriodo(usuarioId, inicio, fin);
    }

    // Último informe por usuario y tipo
    @GetMapping("/usuario/{usuarioId}/ultimo")
    public Informe ultimoPorUsuarioYTipo(
            @PathVariable int usuarioId,
            @RequestParam String tipoInforme) {
        return informeService.findUltimoPorUsuarioYTipo(usuarioId, tipoInforme);
    }
}
