package co.edu.ue.repository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Prediccione;
import co.edu.ue.jpa.JpaPrediccione;

@Repository
public class PrediccioneRepository implements PrediccioneRepositoryI {

    @Autowired
    private JpaPrediccione jpaPrediccione;

    @Override
    public Prediccione insertPrediccion(Prediccione prediccion) {
        return jpaPrediccione.save(prediccion);
    }

    @Override
    public Prediccione updatePrediccion(Prediccione prediccion) {
        return jpaPrediccione.save(prediccion);
    }

    @Override
    public int deletePrediccion(int prediccionId) {
        if (jpaPrediccione.existsById(prediccionId)) {
            jpaPrediccione.deleteById(prediccionId);
            return 1;
        }
        return 0;
    }

    @Override
    public Prediccione findById(int prediccionId) {
        return jpaPrediccione.findById(prediccionId).orElse(null);
    }

    @Override
    public List<Prediccione> listAll() {
        return jpaPrediccione.findAll();
    }

    @Override
    public List<Prediccione> findByUsuario(int usuarioId) {
        return jpaPrediccione.findByUsuarioId(usuarioId);
    }

    @Override
    public List<Prediccione> findByProducto(int productoId) {
        return jpaPrediccione.findByProductoId(productoId);
    }

    @Override
    public List<Prediccione> findByTipo(String tipoPrediccion) {
        return jpaPrediccione.findByTipoPrediccion(tipoPrediccion);
    }

    @Override
    public List<Prediccione> findByUsuarioAndTipo(int usuarioId, String tipoPrediccion) {
        return jpaPrediccione.findByUsuarioIdAndTipoPrediccion(usuarioId, tipoPrediccion);
    }

    @Override
    public List<Prediccione> findByUsuarioAndFechas(int usuarioId, Date inicio, Date fin) {
        return jpaPrediccione.findByUsuarioIdAndFechaPrediccionBetween(usuarioId, inicio, fin);
    }

    @Override
    public List<Prediccione> findByPeriodoObjetivo(String periodoObjetivo) {
        return jpaPrediccione.findByPeriodoObjetivo(periodoObjetivo);
    }

    @Override
    public Prediccione findUltimaPorUsuarioYProducto(int usuarioId, int productoId) {
        return jpaPrediccione.findTopByUsuarioIdAndProductoIdOrderByCreadoDesc(usuarioId, productoId)
                .orElse(null);
    }
}
