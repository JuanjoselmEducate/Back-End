package co.edu.ue.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Gasto;
import co.edu.ue.jpa.JpaGasto;

@Repository
public class GastoRepository implements GastoRepositoryI {

    @Autowired
    private JpaGasto jpaGasto;

    @Override
    public Gasto insertGasto(Gasto gasto) {
        return jpaGasto.save(gasto);
    }

    @Override
    public Gasto updateGasto(Gasto gasto) {
        return jpaGasto.save(gasto);
    }

    @Override
    public int deleteGasto(int gastoId) {
        if (jpaGasto.existsById(gastoId)) {
            jpaGasto.deleteById(gastoId);
            return 1;
        }
        return 0;
    }

    @Override
    public Gasto findById(int gastoId) {
        return jpaGasto.findById(gastoId).orElse(null);
    }

    @Override
    public List<Gasto> listAll() {
        return jpaGasto.findAll();
    }

    @Override
    public List<Gasto> findByUsuario(int usuarioId) {
        return jpaGasto.findByUsuarioId(usuarioId);
    }

    @Override
    public List<Gasto> findByCategoria(int categoriaId) {
        return jpaGasto.findByCategoriaId(categoriaId);
    }

    @Override
    public List<Gasto> findByUsuarioAndFechas(int usuarioId, Date inicio, Date fin) {
        return jpaGasto.findByUsuarioIdAndFechaGastoBetween(usuarioId, inicio, fin);
    }

    @Override
    public BigDecimal totalPorUsuario(int usuarioId) {
        return jpaGasto.obtenerTotalGastosPorUsuario(usuarioId);
    }

    @Override
    public BigDecimal totalPorCategoria(int categoriaId) {
        return jpaGasto.obtenerTotalPorCategoria(categoriaId);
    }
}
