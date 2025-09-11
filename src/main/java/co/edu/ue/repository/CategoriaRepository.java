package co.edu.ue.repository;

import co.edu.ue.entity.Categoria;
import co.edu.ue.jpa.JpaCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoriaRepository implements CategoriaRepositoryI{

    @Autowired
    JpaCategoria jpa;

    @Override
    public Categoria createCategoria(Categoria categoria) {
        return jpa.save(categoria);
    }

    @Override
    public Categoria readCategoria(Integer id) {
        return jpa.findById(id).orElse(null);
    }

    @Override
    public Categoria updateCategoria(Categoria categoria) {
        return jpa.save(categoria);
    }

    @Override
    public Categoria findbyNombre(String nombre,  Integer usuarioId) {
        return jpa.findByNombreAndUsuarioId(nombre, usuarioId);
    }

    @Override
    public List<Categoria> findbyTipo(String tipo,  Integer usuarioId) {
        return jpa.findByTipoAndUsuarioId(tipo, usuarioId);
    }

    @Override
    public List<Categoria> findbyUsuarioId(Integer usuarioId) {
        return jpa.findByUsuarioId(usuarioId);
    }

    @Override
    public List<Categoria> listAll() {
        return jpa.findAll();
    }
}
