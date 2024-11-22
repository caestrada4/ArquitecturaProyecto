package com.example.sistema_suscripcion.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

   /* @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Opcional, dependiendo si necesitas protección CSRF
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/usuarios/**").hasRole("ADMIN") // Solo el admin puede acceder
                        .requestMatchers("/api/cursos/**").hasAnyRole("ADMIN", "CREATOR") // Admin y Creadores
                        .requestMatchers("/api/suscripciones/**").hasRole("CONSUMIDOR") // Consumidores
                        .anyRequest().authenticated() // Resto de las peticiones requieren autenticación
                )
                .httpBasic(); // Configuración básica para Postman
        return http.build();
    }*/



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // Permitir acceso a todas las rutas
                );
        return http.build();
    }

}
