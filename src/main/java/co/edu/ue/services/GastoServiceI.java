package co.edu.ue.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import co.edu.ue.entity.Gasto;

public interface GastoServiceI {
	
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
