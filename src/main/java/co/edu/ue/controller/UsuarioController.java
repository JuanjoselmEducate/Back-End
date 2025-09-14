package co.edu.ue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.entity.Usuario;
import co.edu.ue.services.UsuarioServiceI;
import co.edu.ue.services.business_logic.LoginUsuario;
import co.edu.ue.services.business_logic.Response;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;


@RestController
@RequestMapping(value = "/api/usuarios")
public class UsuarioController {

	//Validaciones de datos con expersiones regulares
	
	@Autowired
	private UsuarioServiceI ser;
	
	@GetMapping
	public Response getAllUsuarios(){
		return ser.listUsuario();
	}
	
	@GetMapping("/{id}")
	public Response getById(@PathVariable int id) {
		return ser.readUsuario(id);
	}
	
	@GetMapping("check-status/{id}")
	public Response getStatus(@PathVariable int id) {
		return ser.checkEstado(id);
	}
	
	
	@PostMapping("login")
	public Response login(@RequestBody LoginUsuario loginRequest) {
        Response response = ser.loginUsuario(loginRequest);
        if (response.getStatus() == 200) {
            UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(), null, Collections.emptyList()
                    );
            SecurityContextHolder.getContext().setAuthentication(authToken);
        }

        return response;
	}
	
	@PostMapping
	public Response postCrearUsuario(@RequestBody Usuario usuario){
		return ser.createUsuario(usuario);
	}	
	
	@PutMapping("/{id}")
	public Response putActualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {		
		return ser.updateUsuario(id, usuario);
	}
	
	@GetMapping("email/{email}")
	public Response getCheckEmail(@PathVariable String email){
		return ser.checkEmail(email);
	}
	
	@GetMapping("documento/{documento}")
	public Response getCheckDocumen(@PathVariable Integer documento) {
		return ser.checkDocumento(documento);
	}
	
	
	
}
