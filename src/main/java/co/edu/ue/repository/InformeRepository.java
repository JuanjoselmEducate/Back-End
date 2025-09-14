package co.edu.ue.repository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Informe;
import co.edu.ue.jpa.JpaInforme;

@Repository
public class InformeRepository implements InformeRepositoryI {

    @Autowired
    private JpaInforme jpaInforme;

    @Override
    public Informe insertInforme(Informe informe) {
        return jpaInforme.save(informe);
    }

    @Override
    public Informe updateInforme(Informe informe) {
        return jpaInforme.save(informe);
    }

    @Override
    public int deleteInforme(int informeId) {
        if (jpaInforme.existsById(informeId)) {
            jpaInforme.deleteById(informeId);
            return 1;
        }
        return 0;
    }

    @Override
    public Informe findById(int informeId) {
        return jpaInforme.findById(informeId).orElse(null);
    }

    @Override
    public List<Informe> listAll() {
        return jpaInforme.findAll();
    }

    @Override
    public List<Informe> findByUsuario(int usuarioId) {
        return jpaInforme.findByUsuarioId(usuarioId);
    }

    @Override
    public List<Informe> findByTipo(String tipoInforme) {
        return jpaInforme.findByTipoInforme(tipoInforme);
    }

    @Override
    public List<Informe> findByUsuarioAndPeriodo(int usuarioId, Date inicio, Date fin) {
        return jpaInforme.findByUsuarioIdAndInicioPeriodoGreaterThanEqualAndFinPeriodoLessThanEqual(usuarioId, inicio, fin);
    }

    @Override
    public Informe findUltimoPorUsuarioYTipo(int usuarioId, String tipoInforme) {
        return jpaInforme.findTopByUsuarioIdAndTipoInformeOrderByCreadoDesc(usuarioId, tipoInforme).orElse(null);
    }
}
