package co.edu.ue.services;

import java.util.List;

import co.edu.ue.entity.Usuario;
import co.edu.ue.services.business_logic.LoginUsuario;
import co.edu.ue.services.business_logic.Response;

public interface UsuarioServiceI {

	//Logica del negocio
	Response createUsuario (Usuario usuario);
	Response readUsuario (Integer usuarioId);
	Response updateUsuario (Integer id, Usuario usuario);
	boolean disableUsuario(Usuario usuario);
	boolean activateUsuario(Usuario usuario);
	boolean reportEstado (Usuario usuario);
	Response checkEstado (Integer id);
	
	Response loginUsuario (LoginUsuario usuario);
	
	Response listUsuario();
}
