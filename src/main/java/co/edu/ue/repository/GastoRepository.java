package co.edu.ue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.ue.entity.Gasto;
import java.util.Date;
import java.util.List;

public interface GastoRepository extends JpaRepository<Gasto, Integer> {
    List<Gasto> findByUsuarioId(int userId);
    List<Gasto> findByCategoriaId(int categoriaId);
    List<Gasto> findByTipoGastoIgnoreCase(String tipoGasto);
    List<Gasto> findByFechaGastoBetween(Date inicio, Date fin);
}
