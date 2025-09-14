package co.edu.ue.services;

import java.util.Date;
import java.util.List;

import co.edu.ue.entity.Informe;

public interface InformeServiceI {
    Informe insertInforme(Informe informe);
    Informe updateInforme(Informe informe);
    int deleteInforme(int informeId);

    Informe findById(int informeId);
    List<Informe> listAll();

    List<Informe> findByUsuario(int usuarioId);
    List<Informe> findByTipo(String tipoInforme);
    List<Informe> findByUsuarioAndPeriodo(int usuarioId, Date inicio, Date fin);

    Informe findUltimoPorUsuarioYTipo(int usuarioId, String tipoInforme);
}
