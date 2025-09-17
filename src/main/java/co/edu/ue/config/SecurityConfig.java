    package co.edu.ue.config;

    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.http.HttpMethod;
    import org.springframework.security.config.annotation.web.builders.HttpSecurity;
    import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
    import org.springframework.security.config.http.SessionCreationPolicy;
    import org.springframework.security.web.SecurityFilterChain;
    import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
    import org.springframework.web.cors.CorsConfiguration;
    import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
    import org.springframework.web.cors.CorsConfigurationSource;

    import java.util.List;

    @Configuration
    @EnableWebSecurity
    public class SecurityConfig {

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http
                    .csrf(csrf -> csrf.disable())
                    .cors(cors -> cors.disable()) // incluso puedes desactivar CORS si no lo necesitas
                    .authorizeHttpRequests(auth -> auth
                            .anyRequest().permitAll()
                    )
                    .sessionManagement(sm -> sm.disable())
                    .securityContext(sc -> sc.disable());
            return http.build();
        }

        // Configura aquí el/los orígenes de tu frontend
        @Bean
        public CorsConfigurationSource corsConfigurationSource() {
            CorsConfiguration cfg = new CorsConfiguration();
            cfg.setAllowedOrigins(List.of("http://localhost:63342", "http://127.0.0.1:*", "http://localhost:*"));
            cfg.setAllowedOriginPatterns(List.of("http://localhost:*", "http://127.0.0.1:*"));
            cfg.setAllowedMethods(List.of("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
            cfg.setAllowedHeaders(List.of("Content-Type", "Authorization", "Accept"));
            cfg.setExposedHeaders(List.of("Set-Cookie"));
            cfg.setAllowCredentials(true);
            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", cfg);
            return source;
        }
    }