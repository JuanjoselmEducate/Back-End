package co.edu.ue.jpa;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.entity.Informe;

public interface JpaInforme extends JpaRepository<Informe, Integer> {

    // Todos los informes de un usuario
    List<Informe> findByUsuarioId(int usuarioId);

    // Por tipo
    List<Informe> findByTipoInforme(String tipoInforme);


    // Por usuario y rango de periodo
    List<Informe> findByUsuarioIdAndInicioPeriodoGreaterThanEqualAndFinPeriodoLessThanEqual(
            int usuarioId, Date desde, Date hasta);

    // Último informe (más reciente) por usuario y tipo
    Optional<Informe> findTopByUsuarioIdAndTipoInformeOrderByCreadoDesc(int usuarioId, String tipoInforme);


}
