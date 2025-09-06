package co.edu.ue.services;

import java.util.List;

import co.edu.ue.entity.Usuario;

public interface UsuarioServiceI {

	//Logica del negocio
	Usuario createUsuario (Usuario usuario);
	Usuario readUsuario (int usuarioId);
	Usuario updateUsuario (Usuario usuario);
	Integer deleteUsuario (Usuario usuario);

	List<Usuario> listUsuario();
}
