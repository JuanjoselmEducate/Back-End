package co.edu.ue.services;


import co.edu.ue.entity.Usuario;
import co.edu.ue.repository.UsuarioRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import co.edu.ue.services.business_logic.HashContrasena;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private HashContrasena hash;

    private final UsuarioRepositoryI usuarioRepository;

    public CustomUserDetailsService(UsuarioRepositoryI usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findbyEmail(email);

        if (usuario == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(usuario.getEmail())
                .password(usuario.getContrasenaHash())
                .roles("USER")
                .build();
    }
}