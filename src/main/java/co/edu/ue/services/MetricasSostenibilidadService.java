package co.edu.ue.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.ue.entity.MetricasSostenibilidad;
import co.edu.ue.repository.MetricasSostenibilidadRepositoryI;

@Service
public class MetricasSostenibilidadService implements MetricasSostenibilidadServiceI {

    private final MetricasSostenibilidadRepositoryI repo;

    public MetricasSostenibilidadService(MetricasSostenibilidadRepositoryI repo) {
        this.repo = repo;
    }

    @Override
    @Transactional
    public MetricasSostenibilidad insert(MetricasSostenibilidad m) {
        validar(m, true);
        return repo.insert(m);
    }

    @Override
    @Transactional
    public MetricasSostenibilidad update(MetricasSostenibilidad m) {
        if (m.getId() <= 0) throw new IllegalArgumentException("ID inválido");
        validar(m, false);
        return repo.update(m);
    }

    @Override
    @Transactional
    public int delete(int metricaId) {
        return repo.delete(metricaId);
    }

    @Override
    public MetricasSostenibilidad findById(int metricaId) {
        return repo.findById(metricaId);
    }

    @Override
    public List<MetricasSostenibilidad> listAll() {
        return repo.listAll();
    }

    @Override
    public List<MetricasSostenibilidad> findByUsuario(int usuarioId) {
        return repo.findByUsuario(usuarioId);
    }

    @Override
    public List<MetricasSostenibilidad> findByTipo(String tipoMetrica) {
        return repo.findByTipo(tipoMetrica);
    }

    @Override
    public List<MetricasSostenibilidad> findByUsuarioAndTipo(int usuarioId, String tipoMetrica) {
        return repo.findByUsuarioAndTipo(usuarioId, tipoMetrica);
    }

    @Override
    public List<MetricasSostenibilidad> findByUsuarioAndFechas(int usuarioId, Date inicio, Date fin) {
        return repo.findByUsuarioAndFechas(usuarioId, inicio, fin);
    }

    @Override
    public MetricasSostenibilidad findUltimaPorUsuarioYTipo(int usuarioId, String tipoMetrica) {
        return repo.findUltimaPorUsuarioYTipo(usuarioId, tipoMetrica);
    }

    private void validar(MetricasSostenibilidad m, boolean creacion) {
        if (m.getTipoMetrica() == null || m.getTipoMetrica().isBlank())
            throw new IllegalArgumentException("El tipo de métrica es obligatorio");
        if (m.getUsuario() == null || m.getUsuario().getId() <= 0)
            throw new IllegalArgumentException("Debe asociar un usuario válido");
        if (m.getFechaMedicion() == null)
            throw new IllegalArgumentException("La fecha de medición es obligatoria");
        if (m.getValor() == null)
            throw new IllegalArgumentException("El valor de la métrica es obligatorio");
    }
}
