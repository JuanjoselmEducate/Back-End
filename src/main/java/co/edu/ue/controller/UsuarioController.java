package co.edu.ue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.entity.Usuario;
import co.edu.ue.services.UsuarioServiceI;
import co.edu.ue.services.business_logic.LoginUsuario;
import co.edu.ue.services.business_logic.Response;
import org.springframework.web.bind.annotation.PathVariable;


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
	
	@GetMapping("chech-status/{id}")
	public Response getStatus(@PathVariable int id) {
		return ser.checkEstado(id);
	}
	
	
	@PostMapping("login")
	public Response login(@RequestBody LoginUsuario loginRequest) {
		return ser.loginUsuario(loginRequest);
	}
	
	@PostMapping
	public Response postCrearUsuario(@RequestBody Usuario usuario){
		return ser.createUsuario(usuario);
	}	
	
	@PutMapping("/{id}")
	public Response putActualizarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {		
		return ser.updateUsuario(id, usuario);
	}
	
}
