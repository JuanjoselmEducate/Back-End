package co.edu.ue.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Usuario;

@Repository
public interface UsuarioRepositoryI {

	Usuario createUsuario (Usuario usuario);
	Usuario readUsuario (int usuarioId);
	Usuario updateUsuario (Usuario usuario);
	Integer deleteUsuario (Usuario usuario);
	
	Usuario findbyEmail(String email);
	Usuario findbyDocumento(String documento);

	List<Usuario> listUsuario();
}
