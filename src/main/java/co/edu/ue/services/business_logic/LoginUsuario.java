package co.edu.ue.services.business_logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.ue.entity.Usuario;
import co.edu.ue.jpa.JpaUsuario;

@Service
public class LoginUsuario implements LoginUsuarioI {
    
    @Autowired
    private JpaUsuario jpa; 
    
    @Autowired
    private HashContrasena hash;
    
    private String email;
    private String contrasena;
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getContrasena() {
        return contrasena;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    @Override
    public Response login(LoginUsuario usuario) {
        Response response = new Response();
        
        Usuario usuario_obj = jpa.findByEmail(usuario.getEmail());
        
        if(usuario_obj != null) {     
            if(hash.hashContrasenaValidated(usuario.getContrasena(), usuario_obj.getContrasenaHash())) {
                response.setResponse(usuario_obj);
                response.setStatus(200);
            } else {
                response.setResponse("Contraseña incorrecta.");
                response.setStatus(401);
            }
        } else {
            response.setResponse("Email no encontrado!");
            response.setStatus(404);
        }
        return response;
    }
}