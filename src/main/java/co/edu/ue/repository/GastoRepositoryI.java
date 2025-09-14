package co.edu.ue.repository;

import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import co.edu.ue.entity.Gasto;

public interface GastoRepositoryI {

    Gasto insertGasto(Gasto gasto);
    Gasto updateGasto(Gasto gasto);
    int deleteGasto(int gastoId);

    Gasto findById(int gastoId);
    List<Gasto> listAll();

    List<Gasto> findByUsuario(int usuarioId);
    List<Gasto> findByCategoria(int categoriaId);
    List<Gasto> findByUsuarioAndFechas(int usuarioId, Date inicio, Date fin);

    BigDecimal totalPorUsuario(int usuarioId);
    BigDecimal totalPorCategoria(int categoriaId);
}
