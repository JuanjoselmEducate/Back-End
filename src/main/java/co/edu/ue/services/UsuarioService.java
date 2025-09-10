package co.edu.ue.services;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.regex.Pattern;


import co.edu.ue.entity.Usuario;
import co.edu.ue.repository.UsuarioRepositoryI;
import co.edu.ue.services.business_logic.HashContrasena;
import co.edu.ue.services.business_logic.LoginUsuario;
import co.edu.ue.services.business_logic.Response;

@Service
public class UsuarioService implements UsuarioServiceI {

	@Autowired
	private UsuarioRepositoryI rep;
	
	@Autowired
	private LoginUsuario login;
	
	@Autowired
	private HashContrasena hash;
	
	 @Override
	    public Response createUsuario(Usuario usuario) {
		 	Response response = new Response();
	        String menssage = "";
	        int status = 0;
	        if(rep.findbyEmail(usuario.getEmail()) == null &&
	           rep.findbyDocumento(usuario.getDocumento()) == null) {
	            String contrasenaHash = hash.hashContrasena(usuario.getContrasenaHash());
	            usuario.setContrasenaHash(contrasenaHash);
	            Response validatedEmail = this.checkEmail(usuario.getEmail());
	            if(validatedEmail.getStatus() == 200) {
	            	Response validatedDocumento = this.checkDocumento(Integer.valueOf(usuario.getDocumento()));
	            	if(validatedDocumento.getStatus() == 200) {

			            rep.createUsuario(usuario);
			            menssage = "Usuario creado con exito!";
			            status = 201;	

	            	}else {
	            		menssage = validatedDocumento.getResponse().toString();
	            		status = validatedDocumento.getStatus();
	            	}
		            
	            }else {
	            	menssage = validatedEmail.getResponse().toString();
	            	status = validatedEmail.getStatus();
	            }
	        }else {
	        	menssage = "Error al crear el usuario, valida el documento o el email.";
	        	status = 400;
	        }
	        return response.buildResponse(menssage, status);
	    }

	@Override
	public Response readUsuario(Integer usuarioId) {
		Response response = new Response();
		Usuario usuario = rep.readUsuario(usuarioId);
		if (usuario == null) {
			String menssage = "No se encuentra un usuarion para ese ID.";
			int status = 204;
			response.buildResponse(menssage, status);
		}else {
			int status = 200;
			response.buildResponse(usuario, status);
		}
		return response;
	}

	@Override
	public Response updateUsuario(Integer id, Usuario usuario) {
	    Response response = new Response();
	    
	    Usuario usuarioExistente = rep.readUsuario(id);
	    if (usuarioExistente == null) {
	        return response.buildResponse("Usuario no encontrado", 404);
	    }
	    
	    if (usuario.getEmail() != null && !usuario.getEmail().equals(usuarioExistente.getEmail())) {
	        Usuario usuarioConEmail = rep.findbyEmail(usuario.getEmail());
	        int idEmail = usuarioConEmail.getId();
	        if (usuarioConEmail != null && idEmail == id  ) {
	            return response.buildResponse("El email ya está en uso por otro usuario", 409);
	        }
	    }
	    
	    if (usuario.getDocumento() != null && !usuario.getDocumento().equals(usuarioExistente.getDocumento())) {
	        Usuario usuarioConDocumento = rep.findbyDocumento(usuario.getDocumento());
	        if (usuarioConDocumento != null && !(usuarioConDocumento.getId() == id)) {
	            return response.buildResponse("El documento ya está en uso por otro usuario", 409);
	        }
	    }
	    
	    if (usuario.getPrimerNombre() != null) {
	        usuarioExistente.setPrimerNombre(usuario.getPrimerNombre());
	    }
	    if (usuario.getSegundoNombre() != null) {
	        usuarioExistente.setSegundoNombre(usuario.getSegundoNombre());
	    }
	    if (usuario.getApellidos() != null) {
	        usuarioExistente.setApellidos(usuario.getApellidos());
	    }
	    if (usuario.getEmail() != null) {
	        usuarioExistente.setEmail(usuario.getEmail());
	    }
	    if (usuario.getDocumento() != null) {
	        usuarioExistente.setDocumento(usuario.getDocumento());
	    }
	    if (usuario.getTelefono() != null) {
	        usuarioExistente.setTelefono(usuario.getTelefono());
	    }
	    if (usuario.getNombreEmpresa() != null) {
	        usuarioExistente.setNombreEmpresa(usuario.getNombreEmpresa());
	    }
	    if (usuario.getTipoNegocio() != null) {
	        usuarioExistente.setTipoNegocio(usuario.getTipoNegocio());
	    }
	    if (usuario.getDireccion() != null) {
	        usuarioExistente.setDireccion(usuario.getDireccion());
	    }
	    if (usuario.getEstado() == 1) {
	    	boolean estado = (usuario.getEstado() == 1)? true: false;
	        usuarioExistente.setEstado(estado);
	    }
	    
	    if (usuario.getContrasenaHash() != null && !usuario.getContrasenaHash().isEmpty()) {
	        String contrasenaHash = hash.hashContrasena(usuario.getContrasenaHash());
	        usuarioExistente.setContrasenaHash(contrasenaHash);
	    }
	    
	    if(usuario.getCreado() == null && usuario.getActualizado() == null ) {
	    	usuarioExistente.setActualizado(Timestamp.from(Instant.now()));
	    	usuarioExistente.setCreado(usuarioExistente.getCreado());
	    }
	    try {
	        Usuario usuarioActualizado = rep.updateUsuario(usuarioExistente);
	        return response.buildResponse("Usuario actualizado exitosamente", 200);
	    } catch (Exception e) {
	        return response.buildResponse("Error al actualizar el usuario: " + e.getMessage(), 500);
	    }
	}

	@Override
	public Response listUsuario() {
		Response response = new Response();
		List<Usuario> usuarios = new ArrayList<Usuario>() ; 
		usuarios = rep.listUsuario();
		int status = 0;
		if(usuarios == null) {
			String data = "";
			data = "No se encuentran usuarios activos.";
			status = 204; 
			response = response.buildResponse(data, status);
		}else {
			status = 200;
			response = response.buildResponse(usuarios, status);
		}
		return response;
	}

	@Override
	public boolean disableUsuario(Usuario usuario) {
		boolean data = false;
		if(this.reportEstado(usuario)) {
			usuario.setEstado(false);
			rep.updateUsuario(usuario);
			data = true;
		}
		return data;
	}


	@Override
	public boolean activateUsuario(Usuario usuario) {
		boolean data = true;
		if(!this.reportEstado(usuario)) {
			usuario.setEstado(false);
			rep.updateUsuario(usuario);
			data = false;
		}
		return data;
	}

	@Override
	public boolean reportEstado(Usuario usuario) {
		boolean data = false;
		if(usuario.getEstado()==1) {
			data = true;
		}
		return data;
	}

	@Override
	public Response loginUsuario(LoginUsuario usuario) {
		return login.login(usuario);
	}

	@Override
	public Response checkEstado(Integer id) {
		int status = 0;
		Response response = new Response();
		Usuario usuario = rep.readUsuario(id);
		if(usuario == null) {
			String menssaje = "";
			menssaje = "El usuario no se a encontrado.";
			status = 404;
			response.setResponse(menssaje);
		}else{
			byte estado_byte = usuario.getEstado();
			boolean estado = (estado_byte!=0)? true:false;
			Boolean menssaje = estado;
			status = 200; 
			response.setResponse(menssaje);
		}
		response.setStatus(status);		
		return response;
	}

	@Override
	public Response checkEmail(String email) {
		Response response = new Response();
		String menssage = "";
		Integer status = 400;
	    String regexPattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
	    if (!Pattern.compile(regexPattern).matcher(email).matches()) {
	        menssage = "El formato del email no es válido.";
	        response.buildResponse(menssage, status);
	        return response;
	    }
		if(rep.findbyEmail(email) == null){
			menssage = "El email esta disponible.";
			status = 200;
		}else {
			menssage = "El email no esta disponible.";
		}
		return response.buildResponse(menssage, status);
	}

	@Override
	public Response checkDocumento(Integer documento) {
		Response response = new Response();
		String menssage = "";
		Integer status = 400;
		if(documento<100000 || documento == null){
			menssage = "El documento no es valido!";
			return response.buildResponse(menssage, status);
		}
		if(rep.findbyDocumento(Integer.toString(documento)) == null){
			menssage = "El documento es posible de usar.";
			status = 200;
		}else{
			menssage = "El documento no es valido!";
		}
		return response.buildResponse(menssage, status);
	}
}
