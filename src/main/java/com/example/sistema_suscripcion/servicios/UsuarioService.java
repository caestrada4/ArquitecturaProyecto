package com.example.sistema_suscripcion.servicios;

import com.example.sistema_suscripcion.DTOs.UsuarioDTO;
import com.example.sistema_suscripcion.entidades.Usuario;
import com.example.sistema_suscripcion.excepciones.RecursoNoEncontradoExcepcion;
import com.example.sistema_suscripcion.mapeadores.UsuarioMapper;
import com.example.sistema_suscripcion.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        Usuario saved = usuarioRepository.save(usuario);
        return usuarioMapper.toDto(saved);
    }

    public UsuarioDTO modificarUsuario(Long id, UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("Usuario no encontrado"));
        usuario.setNombres(usuarioDTO.getNombres());
        usuario.setApellidos(usuarioDTO.getApellidos());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setContraseña(usuarioDTO.getContraseña());
        usuario.setTipoUsuario(Usuario.TipoUsuario.valueOf(usuarioDTO.getTipoUsuario()));
        Usuario updated = usuarioRepository.save(usuario);
        return usuarioMapper.toDto(updated);
    }

    public void eliminarUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RecursoNoEncontradoExcepcion("Usuario no encontrado");
        }
        usuarioRepository.deleteById(id);
    }

    public UsuarioDTO consultarUsuarioPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoExcepcion("Usuario no encontrado"));
        return usuarioMapper.toDto(usuario);
    }

    public List<UsuarioDTO> listarUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::toDto)
                .collect(Collectors.toList());
    }
}
