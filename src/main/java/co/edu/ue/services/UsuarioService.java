package co.edu.ue.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.entity.Usuario;
import co.edu.ue.repository.UsuarioRepositoryI;

@Service
public class UsuarioService implements UsuarioServiceI {

	@Autowired
	private UsuarioRepositoryI rep;
	
	@Override
	public Usuario createUsuario(Usuario usuario) {
		//Logica
		if(rep.findbyEmail(usuario.getDocumento()).equals(null)
				&&
			rep.findbyEmail(usuario.getEmail()).equals(null)){
				return rep.createUsuario(usuario);			
		}
		return null;
	}

	@Override
	public Usuario readUsuario(int usuarioId) {
		return rep.readUsuario(usuarioId);
		
	}

	@Override
	public Usuario updateUsuario(Usuario usuario) {
		if (!rep.findbyEmail(usuario.getDocumento()).equals(null)
				&&
			!rep.readUsuario(usuario.getId()).equals(usuario.getId())) {
			return rep.updateUsuario(usuario);
		}
		return null;
	}

	@Override
	public Integer deleteUsuario(Usuario usuario) {
		if(rep.findbyDocumento(usuario.getDocumento()).equals(null)) {
			return 0;
		}
		return rep.deleteUsuario(usuario);
	}

	@Override
	public List<Usuario> listUsuario() {
		return rep.listUsuario();
	}

}
