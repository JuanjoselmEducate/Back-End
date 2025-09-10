package co.edu.ue.jpa;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.entity.MetricasSostenibilidad;

public interface JpaMetricasSostenibilidad extends JpaRepository<MetricasSostenibilidad, Integer> {

    // Buscar todas las métricas de un usuario
    List<MetricasSostenibilidad> findByUsuarioId(int usuarioId);

    // Buscar por tipo de métrica (ej: "CO2", "Consumo Agua")
    List<MetricasSostenibilidad> findByTipoMetrica(String tipoMetrica);

    // Buscar por usuario y tipo
    List<MetricasSostenibilidad> findByUsuarioIdAndTipoMetrica(int usuarioId, String tipoMetrica);


    // Buscar métricas de un usuario en un rango de fechas
    List<MetricasSostenibilidad> findByUsuarioIdAndFechaMedicionBetween(int usuarioId, Date inicio, Date fin);

    // Última métrica registrada por usuario y tipo (ordenada por fecha de medición o por creado)
    Optional<MetricasSostenibilidad> findTopByUsuarioIdAndTipoMetricaOrderByFechaMedicionDesc(int usuarioId, String tipoMetrica);

}
