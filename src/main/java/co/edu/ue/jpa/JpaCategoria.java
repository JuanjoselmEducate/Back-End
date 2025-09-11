package co.edu.ue.jpa;

import co.edu.ue.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaCategoria extends JpaRepository<Categoria,Integer> {
    Categoria findByNombreAndUsuarioId(String nombre, Integer usuarioId);

    List<Categoria> findByTipoAndUsuarioId(String tipo, Integer usuarioId);
    List<Categoria> findByUsuarioId (Integer usuarioId);
}
