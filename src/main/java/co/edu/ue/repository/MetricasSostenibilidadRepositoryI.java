package co.edu.ue.repository;

import java.util.Date;
import java.util.List;

import co.edu.ue.entity.MetricasSostenibilidad;

public interface MetricasSostenibilidadRepositoryI {
    MetricasSostenibilidad insert(MetricasSostenibilidad metrica);
    MetricasSostenibilidad update(MetricasSostenibilidad metrica);
    int delete(int metricaId);

    MetricasSostenibilidad findById(int metricaId);
    List<MetricasSostenibilidad> listAll();

    List<MetricasSostenibilidad> findByUsuario(int usuarioId);
    List<MetricasSostenibilidad> findByTipo(String tipoMetrica);
    List<MetricasSostenibilidad> findByUsuarioAndTipo(int usuarioId, String tipoMetrica);
    List<MetricasSostenibilidad> findByUsuarioAndFechas(int usuarioId, Date inicio, Date fin);
    MetricasSostenibilidad findUltimaPorUsuarioYTipo(int usuarioId, String tipoMetrica);
}
