package co.edu.ue.services;

import co.edu.ue.entity.Categoria;
import co.edu.ue.services.business_logic.Response;
import co.edu.ue.services.business_logic.create.CategoriaCreate;

public interface CategoriaServiceI {
    Response createCategoria(CategoriaCreate categoriaCreate);
    Response readCategoria(Integer id);
    Response updateCategoria(Integer id,CategoriaCreate categoriaCreate);

    Response findByNombre(String nombre, Integer usuarioId);
    Response findByTipo(String tipo,  Integer usuarioId);

    Response listFindByUsuarioId(Integer id);
    Response listCategorias ();
}
