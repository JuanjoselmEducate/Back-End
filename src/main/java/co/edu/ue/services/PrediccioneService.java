package co.edu.ue.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.ue.entity.Prediccione;
import co.edu.ue.repository.PrediccioneRepositoryI;

@Service
public class PrediccioneService implements PrediccioneServiceI {

    private final PrediccioneRepositoryI repo;

    public PrediccioneService(PrediccioneRepositoryI repo) {
        this.repo = repo;
    }

    @Override
    @Transactional
    public Prediccione insertPrediccion(Prediccione prediccion) {
        validarPrediccion(prediccion, true);
        return repo.insertPrediccion(prediccion);
    }

    @Override
    @Transactional
    public Prediccione updatePrediccion(Prediccione prediccion) {
        if (prediccion.getId() <= 0) throw new IllegalArgumentException("ID inválido");
        validarPrediccion(prediccion, false);
        return repo.updatePrediccion(prediccion);
    }

    @Override
    @Transactional
    public int deletePrediccion(int prediccionId) {
        return repo.deletePrediccion(prediccionId);
    }

    @Override
    public Prediccione findById(int prediccionId) {
        return repo.findById(prediccionId);
    }

    @Override
    public List<Prediccione> listAll() {
        return repo.listAll();
    }

    @Override
    public List<Prediccione> findByUsuario(int usuarioId) {
        return repo.findByUsuario(usuarioId);
    }

    @Override
    public List<Prediccione> findByProducto(int productoId) {
        return repo.findByProducto(productoId);
    }

    @Override
    public List<Prediccione> findByTipo(String tipoPrediccion) {
        return repo.findByTipo(tipoPrediccion);
    }

    @Override
    public List<Prediccione> findByUsuarioAndTipo(int usuarioId, String tipoPrediccion) {
        return repo.findByUsuarioAndTipo(usuarioId, tipoPrediccion);
    }

    @Override
    public List<Prediccione> findByUsuarioAndFechas(int usuarioId, Date inicio, Date fin) {
        return repo.findByUsuarioAndFechas(usuarioId, inicio, fin);
    }

    @Override
    public List<Prediccione> findByPeriodoObjetivo(String periodoObjetivo) {
        return repo.findByPeriodoObjetivo(periodoObjetivo);
    }

    @Override
    public Prediccione findUltimaPorUsuarioYProducto(int usuarioId, int productoId) {
        return repo.findUltimaPorUsuarioYProducto(usuarioId, productoId);
    }

    private void validarPrediccion(Prediccione pred, boolean esCreacion) {
        if (pred.getTipoPrediccion() == null || pred.getTipoPrediccion().isBlank()) {
            throw new IllegalArgumentException("El tipo de predicción es obligatorio");
        }
        if (pred.getUsuario() == null || pred.getUsuario().getId() <= 0) {
            throw new IllegalArgumentException("Debe estar asociada a un usuario válido");
        }
        if (pred.getProducto() == null || pred.getProducto().getId() <= 0) {
            throw new IllegalArgumentException("Debe estar asociada a un producto válido");
        }
        if (pred.getFechaPrediccion() == null) {
            throw new IllegalArgumentException("La fecha de predicción es obligatoria");
        }
    }
}
