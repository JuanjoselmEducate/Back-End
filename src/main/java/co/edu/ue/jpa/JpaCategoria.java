package co.edu.ue.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.ue.entity.Categoria;

public interface JpaCategoria extends JpaRepository<Categoria, Integer> {
}
