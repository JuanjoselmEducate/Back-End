package co.edu.ue.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.ue.entity.Gasto;
import co.edu.ue.repository.GastoRepositoryI;

@Service
public class GastoService implements GastoServiceI {

    private final GastoRepositoryI repo;

    // ✅ Constructor injection (recomendado)
    public GastoService(GastoRepositoryI repo) {
        this.repo = repo;
    }

    // --------- Write ---------
    @Override
    @Transactional
    public Gasto insertGasto(Gasto gasto) {
        validarGasto(gasto, true);
        return repo.insertGasto(gasto);
    }

    @Override
    @Transactional
    public Gasto updateGasto(Gasto gasto) {
        if (gasto == null || gasto.getId() <= 0) {
            throw new IllegalArgumentException("ID de gasto inválido para actualizar");
        }
        validarGasto(gasto, false);
        // (opcional) validar existencia previa
        Gasto existente = repo.findById(gasto.getId());
        if (existente == null) {
            throw new IllegalArgumentException("No existe el gasto con id " + gasto.getId());
        }
        return repo.updateGasto(gasto);
    }

    @Override
    @Transactional
    public int deleteGasto(int gastoId) {
        if (gastoId <= 0) throw new IllegalArgumentException("ID inválido");
        return repo.deleteGasto(gastoId);
    }

    // --------- Read ---------
    @Override
    @Transactional(readOnly = true)
    public Gasto findById(int gastoId) {
        if (gastoId <= 0) throw new IllegalArgumentException("ID inválido");
        return repo.findById(gastoId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Gasto> listAll() {
        return repo.listAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Gasto> findByUsuario(int usuarioId) {
        if (usuarioId <= 0) throw new IllegalArgumentException("Usuario inválido");
        return repo.findByUsuario(usuarioId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Gasto> findByCategoria(int categoriaId) {
        if (categoriaId <= 0) throw new IllegalArgumentException("Categoría inválida");
        return repo.findByCategoria(categoriaId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Gasto> findByUsuarioAndFechas(int usuarioId, Date inicio, Date fin) {
        if (usuarioId <= 0) throw new IllegalArgumentException("Usuario inválido");
        if (inicio == null || fin == null) throw new IllegalArgumentException("Rango de fechas es obligatorio");
        if (fin.before(inicio)) throw new IllegalArgumentException("La fecha fin no puede ser anterior a la fecha inicio");
        return repo.findByUsuarioAndFechas(usuarioId, inicio, fin);
    }

    @Override
    @Transactional(readOnly = true)
    public BigDecimal totalPorUsuario(int usuarioId) {
        if (usuarioId <= 0) throw new IllegalArgumentException("Usuario inválido");
        return repo.totalPorUsuario(usuarioId);
    }

    @Override
    @Transactional(readOnly = true)
    public BigDecimal totalPorCategoria(int categoriaId) {
        if (categoriaId <= 0) throw new IllegalArgumentException("Categoría inválida");
        return repo.totalPorCategoria(categoriaId);
    }

    // --------- Validaciones de negocio ---------
    private void validarGasto(Gasto g, boolean esCreacion) {
        if (g == null) throw new IllegalArgumentException("El gasto es requerido");

        if (g.getDescripcion() == null || g.getDescripcion().trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción es obligatoria");
        }
        if (g.getMonto() == null) {
            throw new IllegalArgumentException("El monto es obligatorio");
        }
        if (g.getMonto().signum() < 0) {
            throw new IllegalArgumentException("El monto no puede ser negativo");
        }
        if (g.getFechaGasto() == null) {
            throw new IllegalArgumentException("La fecha del gasto es obligatoria");
        }
        // (opcional) no permitir futuro:
        // if (g.getFechaGasto().after(new Date())) throw new IllegalArgumentException("La fecha no puede estar en el futuro");

        if (g.getUsuario() == null || g.getUsuario().getId() <= 0) {
            throw new IllegalArgumentException("El usuario es obligatorio");
        }
        if (g.getCategoria() == null || g.getCategoria().getId() <= 0) {
            throw new IllegalArgumentException("La categoría es obligatoria");
        }
    }
}
