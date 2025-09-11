package co.edu.ue.repository;

import co.edu.ue.entity.Categoria;

import java.util.List;

public interface CategoriaRepositoryI {
    Categoria createCategoria(Categoria categoria);
    Categoria readCategoria(Integer id);
    Categoria updateCategoria(Categoria categoria);

    Categoria findbyNombre(String nombre, Integer usuarioId);

    List<Categoria> findbyTipo(String tipo, Integer usuarioId);
    List<Categoria> findbyUsuarioId (Integer usuarioId);
    List<Categoria> listAll();
}
