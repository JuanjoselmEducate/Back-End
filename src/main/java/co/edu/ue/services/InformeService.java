package co.edu.ue.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.ue.entity.Informe;
import co.edu.ue.repository.InformeRepositoryI;

@Service
public class InformeService implements InformeServiceI {

    private final InformeRepositoryI repo;

    public InformeService(InformeRepositoryI repo) {
        this.repo = repo;
    }

    @Override
    @Transactional
    public Informe insertInforme(Informe informe) {
        validarInforme(informe, true);
        return repo.insertInforme(informe);
    }

    @Override
    @Transactional
    public Informe updateInforme(Informe informe) {
        if (informe.getId() <= 0) throw new IllegalArgumentException("ID inválido para actualizar");
        validarInforme(informe, false);
        return repo.updateInforme(informe);
    }

    @Override
    @Transactional
    public int deleteInforme(int informeId) {
        return repo.deleteInforme(informeId);
    }

    @Override
    public Informe findById(int informeId) {
        return repo.findById(informeId);
    }

    @Override
    public List<Informe> listAll() {
        return repo.listAll();
    }

    @Override
    public List<Informe> findByUsuario(int usuarioId) {
        return repo.findByUsuario(usuarioId);
    }

    @Override
    public List<Informe> findByTipo(String tipoInforme) {
        return repo.findByTipo(tipoInforme);
    }

    @Override
    public List<Informe> findByUsuarioAndPeriodo(int usuarioId, Date inicio, Date fin) {
        return repo.findByUsuarioAndPeriodo(usuarioId, inicio, fin);
    }

    @Override
    public Informe findUltimoPorUsuarioYTipo(int usuarioId, String tipoInforme) {
        return repo.findUltimoPorUsuarioYTipo(usuarioId, tipoInforme);
    }

    private void validarInforme(Informe informe, boolean esCreacion) {
        if (informe.getTipoInforme() == null || informe.getTipoInforme().isBlank()) {
            throw new IllegalArgumentException("El tipo de informe es obligatorio");
        }
        if (informe.getInicioPeriodo() == null || informe.getFinPeriodo() == null) {
            throw new IllegalArgumentException("Las fechas de inicio y fin de periodo son obligatorias");
        }
        if (informe.getFinPeriodo().before(informe.getInicioPeriodo())) {
            throw new IllegalArgumentException("La fecha fin no puede ser anterior a la fecha inicio");
        }
        if (informe.getUsuario() == null || informe.getUsuario().getId() <= 0) {
            throw new IllegalArgumentException("El informe debe estar asociado a un usuario válido");
        }
    }
}
