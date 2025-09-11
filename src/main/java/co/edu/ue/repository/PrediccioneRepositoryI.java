package co.edu.ue.repository;

import java.util.Date;
import java.util.List;

import co.edu.ue.entity.Prediccione;

public interface PrediccioneRepositoryI {
    Prediccione insertPrediccion(Prediccione prediccion);
    Prediccione updatePrediccion(Prediccione prediccion);
    int deletePrediccion(int prediccionId);

    Prediccione findById(int prediccionId);
    List<Prediccione> listAll();

    List<Prediccione> findByUsuario(int usuarioId);
    List<Prediccione> findByProducto(int productoId);
    List<Prediccione> findByTipo(String tipoPrediccion);
    List<Prediccione> findByUsuarioAndTipo(int usuarioId, String tipoPrediccion);
    List<Prediccione> findByUsuarioAndFechas(int usuarioId, Date inicio, Date fin);
    List<Prediccione> findByPeriodoObjetivo(String periodoObjetivo);
    Prediccione findUltimaPorUsuarioYProducto(int usuarioId, int productoId);
}
