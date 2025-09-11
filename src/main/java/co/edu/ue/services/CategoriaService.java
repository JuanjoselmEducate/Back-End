package co.edu.ue.services;

import co.edu.ue.entity.Categoria;
import co.edu.ue.entity.Usuario;
import co.edu.ue.repository.CategoriaRepository;
import co.edu.ue.repository.UsuarioRepository;
import co.edu.ue.services.business_logic.Response;
import co.edu.ue.services.business_logic.create.CategoriaCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class CategoriaService implements CategoriaServiceI {

    @Autowired
    CategoriaRepository rep;

    @Autowired
    UsuarioRepository repUsuario;

    @Override
    public Response createCategoria(CategoriaCreate categoriaCreate) {
        Response response = new Response();
        Timestamp timeNow = Timestamp.from(Instant.now());
        Usuario usuario = repUsuario.readUsuario(categoriaCreate.getUsuario_Id());
        if (usuario == null) {
            return response.buildResponse("Usuario no encontrado.", 409);
        }
        if (findByNombre(categoriaCreate.getNombre(), usuario.getId()).getStatus() == 200) {
            return response.buildResponse("Nombre de categoria ya existente.", 409);
        }
        Categoria categoria = new Categoria();
        categoria.setUsuario(usuario);
        categoria.setNombre(categoriaCreate.getNombre());
        categoria.setDescripcion(categoriaCreate.getDescripcion());
        categoria.setTipo(categoriaCreate.getTipo());
        categoria.setCreado(timeNow);
        try {
            rep.createCategoria(categoria);
            return response.buildResponse("Categoria creada con éxito", 201);
        } catch (Exception e) {
            return response.buildResponse("Error al crear la categoria: " + e.getMessage(), 500);
        }
    }

    @Override
    public Response readCategoria(Integer id) {
        Response response = new Response();
        Categoria categoria = rep.readCategoria(id);
        if (categoria == null) {
            return response.buildResponse("Categoria no encontrado.", 404);
        }
        return response.buildResponse(categoria, 200);
    }

    @Override
    public Response updateCategoria(Integer id, CategoriaCreate categoriaCreate) {
        Response response = new Response();
        Categoria categoria = rep.readCategoria(id);
        if (categoria == null) {
            return response.buildResponse("Categoria no encontrado.", 404);
        }
        if(categoriaCreate.getUsuario_Id() != null){
            Usuario usuario = repUsuario.readUsuario(id);
            if(usuario==null){
                return response.buildResponse("Usuario no encontrado.", 404);
            }
            categoria.setUsuario(usuario);
        }
        if (findByNombre(categoriaCreate.getNombre(), categoria.getUsuario().getId()).getStatus() == 200) {
            return response.buildResponse("Nombre de categoria ya existente.", 409);
        }
        if(categoriaCreate.getNombre() != null && !categoriaCreate.getNombre().equals("")){
            categoria.setNombre(categoriaCreate.getNombre());
        }
        if(categoriaCreate.getDescripcion() != null && !categoriaCreate.getDescripcion().equals("")){
            categoria.setDescripcion(categoriaCreate.getDescripcion());
        }
        if (categoriaCreate.getTipo() != null && !categoriaCreate.getTipo().equals("")){
            categoria.setTipo(categoriaCreate.getTipo());
        }
        try {
            rep.updateCategoria(categoria);
            return response.buildResponse("Categoria actualizada con éxito", 201);
        } catch (Exception e) {
            return response.buildResponse("Error al actualizar la categoria: " + e.getMessage(), 500);
        }
    }

    @Override
    public Response findByNombre(String nombre, Integer usuarioId) {
        Response response = new Response();
        Usuario usuario = repUsuario.readUsuario(usuarioId);
        if (usuario == null) {
            return response.buildResponse("Usuario no encontrado.", 409);
        }
        if (rep.findbyNombre(nombre, usuarioId) == null) {
            return response.buildResponse("Nombre de categoria no encontrado.", 409);
        }
        return response.buildResponse(rep.findbyNombre(nombre, usuarioId), 200);
    }

    @Override
    public Response findByTipo(String tipo,  Integer usuarioId) {
        Response response = new Response();
        Usuario usuario = repUsuario.readUsuario(usuarioId);
        if (usuario == null) {
            return response.buildResponse("Usuario no encontrado.", 409);
        }
        if (tipo == null || tipo.equals("")) {
            return response.buildResponse("Tipo de categoria no valida.", 404);
        }
        List<Categoria> categoria = rep.findbyTipo(tipo, usuarioId);
        if (categoria != null) {
            return response.buildResponse(categoria, 200);
        }
        return response.buildResponse("Tipo de categoria no encontrado.", 404);
    }

    @Override
    public Response listFindByUsuarioId(Integer id) {
        Response response = new Response();
        if(repUsuario.readUsuario(id) == null) {
            return response.buildResponse("Usuario no encontrado", 404);
        }
        List<Categoria> categorias = rep.findbyUsuarioId(id);
        if (categorias == null) {
            return response.buildResponse("Categoria no encontrado.", 404);
        }
        return response.buildResponse(categorias, 200);
    }

    @Override
    public Response listCategorias() {
        Response response = new Response();
        List<Categoria> allCategorias = rep.listAll();
        if (allCategorias == null) {
            return response.buildResponse("No se encuentran categorias", 204);
        }
        return response.buildResponse(allCategorias,200);
    }
}
