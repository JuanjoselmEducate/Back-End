package co.edu.ue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.entity.Usuario;
import co.edu.ue.services.UsuarioServiceI;

@RestController
@RequestMapping(value = "/api/usuarios")
public class UsuarioController {

	//Validaciones de datos con expersiones regulares
	
	@Autowired
	private UsuarioServiceI ser;
	
	@GetMapping(value = "all")
	public List<Usuario> getAllUsuariosData(){
		return ser.listUsuario();
	}
}
