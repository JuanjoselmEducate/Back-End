package co.edu.ue.jpa;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.ue.entity.Gasto;

public interface JpaGasto extends JpaRepository<Gasto, Integer> {

    // Buscar gastos de un usuario
    List<Gasto> findByUsuarioId(int usuarioId);

    // Buscar gastos por categoría
    List<Gasto> findByCategoriaId(int categoriaId);


    // Buscar gastos de un usuario entre fechas
    List<Gasto> findByUsuarioIdAndFechaGastoBetween(int usuarioId, Date inicio, Date fin);

    // Consulta personalizada con JPQL: suma de gastos de un usuario
    @Query("SELECT SUM(g.monto) FROM Gasto g WHERE g.usuario.id = :usuarioId")
    BigDecimal obtenerTotalGastosPorUsuario(@Param("usuarioId") int usuarioId);

    // Consulta personalizada: suma por categoría
    @Query("SELECT SUM(g.monto) FROM Gasto g WHERE g.categoria.id = :categoriaId")
    BigDecimal obtenerTotalPorCategoria(@Param("categoriaId") int categoriaId);

}
