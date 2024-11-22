package com.example.sistema_suscripcion.mapeadores;

import com.example.sistema_suscripcion.DTOs.UsuarioDTO;
import com.example.sistema_suscripcion.entidades.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioDTO toDto(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNombres(usuario.getNombres());
        dto.setApellidos(usuario.getApellidos());
        dto.setEmail(usuario.getEmail());
        dto.setContraseña(usuario.getContraseña()); // Mapea contraseña
        dto.setTipoUsuario(usuario.getTipoUsuario().toString());
        return dto;
    }

    public Usuario toEntity(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setId(dto.getId());
        usuario.setNombres(dto.getNombres());
        usuario.setApellidos(dto.getApellidos());
        usuario.setEmail(dto.getEmail());
        usuario.setContraseña(dto.getContraseña()); // Mapea contraseña
        usuario.setTipoUsuario(Usuario.TipoUsuario.valueOf(dto.getTipoUsuario()));
        return usuario;
    }
}
