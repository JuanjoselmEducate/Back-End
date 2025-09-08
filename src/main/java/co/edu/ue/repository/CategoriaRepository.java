package co.edu.ue.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Categoria;
import co.edu.ue.jpa.JpaCategoria;

@Repository
public class CategoriaRepository implements CategoriaRepositoryI {

    @Autowired
    JpaCategoria jpa;

    @Override
    public Categoria readCategoria(int id) {
        return jpa.findById(id).orElse(null);
    }
}
