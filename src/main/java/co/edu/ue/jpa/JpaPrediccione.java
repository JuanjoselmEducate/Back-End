package co.edu.ue.jpa;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.entity.Prediccione;

public interface JpaPrediccione extends JpaRepository<Prediccione, Integer> {

    // Buscar todas las predicciones de un usuario
    List<Prediccione> findByUsuarioId(int usuarioId);

    // Buscar todas las predicciones de un producto
    List<Prediccione> findByProductoId(int productoId);

    // Buscar por tipo de predicción (ej: "Demanda", "Ventas")
    List<Prediccione> findByTipoPrediccion(String tipoPrediccion);

    // Buscar predicciones por usuario y tipo
    List<Prediccione> findByUsuarioIdAndTipoPrediccion(int usuarioId, String tipoPrediccion);

    // Buscar predicciones de un usuario en un rango de fechas
    List<Prediccione> findByUsuarioIdAndFechaPrediccionBetween(int usuarioId, Date inicio, Date fin);

    // Buscar por periodo objetivo (ej: "2025-Q1", "2025-09")
    List<Prediccione> findByPeriodoObjetivo(String periodoObjetivo);

    // Última predicción de un usuario y producto (ordenada por fecha de creación)
    Optional<Prediccione> findTopByUsuarioIdAndProductoIdOrderByCreadoDesc(int usuarioId, int productoId);


}
