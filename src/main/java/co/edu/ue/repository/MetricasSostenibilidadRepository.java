package co.edu.ue.repository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.MetricasSostenibilidad;
import co.edu.ue.jpa.JpaMetricasSostenibilidad;

@Repository
public class MetricasSostenibilidadRepository implements MetricasSostenibilidadRepositoryI {

    @Autowired
    private JpaMetricasSostenibilidad jpa;

    @Override
    public MetricasSostenibilidad insert(MetricasSostenibilidad metrica) {
        return jpa.save(metrica);
    }

    @Override
    public MetricasSostenibilidad update(MetricasSostenibilidad metrica) {
        return jpa.save(metrica);
    }

    @Override
    public int delete(int metricaId) {
        if (jpa.existsById(metricaId)) {
            jpa.deleteById(metricaId);
            return 1;
        }
        return 0;
    }

    @Override
    public MetricasSostenibilidad findById(int metricaId) {
        return jpa.findById(metricaId).orElse(null);
    }

    @Override
    public List<MetricasSostenibilidad> listAll() {
        return jpa.findAll();
    }

    @Override
    public List<MetricasSostenibilidad> findByUsuario(int usuarioId) {
        return jpa.findByUsuarioId(usuarioId);
    }

    @Override
    public List<MetricasSostenibilidad> findByTipo(String tipoMetrica) {
        return jpa.findByTipoMetrica(tipoMetrica);
    }

    @Override
    public List<MetricasSostenibilidad> findByUsuarioAndTipo(int usuarioId, String tipoMetrica) {
        return jpa.findByUsuarioIdAndTipoMetrica(usuarioId, tipoMetrica);
    }

    @Override
    public List<MetricasSostenibilidad> findByUsuarioAndFechas(int usuarioId, Date inicio, Date fin) {
        return jpa.findByUsuarioIdAndFechaMedicionBetween(usuarioId, inicio, fin);
    }

    @Override
    public MetricasSostenibilidad findUltimaPorUsuarioYTipo(int usuarioId, String tipoMetrica) {
        return jpa.findTopByUsuarioIdAndTipoMetricaOrderByFechaMedicionDesc(usuarioId, tipoMetrica)
                  .orElse(null);
    }
}
