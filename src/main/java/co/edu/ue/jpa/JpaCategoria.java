package co.edu.ue.jpa;

import co.edu.ue.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaCategoria extends JpaRepository<Categoria,Integer> {
    Categoria findByNombre(String nombre);

    List<Categoria> findAllByTipo(String tipo);
    List<Categoria> findByUsuarioId (Integer usuarioId);
}
