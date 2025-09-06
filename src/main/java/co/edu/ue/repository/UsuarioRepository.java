package co.edu.ue.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Usuario;
import co.edu.ue.jpa.JpaUsuario;

@Repository
public class UsuarioRepository implements UsuarioRepositoryI {

	@Autowired
	JpaUsuario jpa;
	
	@Override
	public Usuario createUsuario(Usuario usuario) {
		return jpa.save(usuario);
	}

	@Override
	public Usuario readUsuario(int usuarioId) {
		return jpa.findById(usuarioId).orElse(null);
	}

	@Override
	public Usuario updateUsuario(Usuario usuario) {
		return jpa.save(usuario);
	}

	@Override
	public Integer deleteUsuario(Usuario usuario) {
		Integer estado = 0;
		if (!jpa.save(usuario).equals(null)) {
			estado = 1;	
		} 
		return estado;
	}

	@Override
	public List<Usuario> listUsuario() {
		return jpa.findAll();
	}

	@Override
	public Usuario findbyEmail(String email) {
		return jpa.findByEmail(email);
	}

	@Override
	public Usuario findbyDocumento(String documento) {
		return jpa.findByDocumento(documento);
	}

	
}
