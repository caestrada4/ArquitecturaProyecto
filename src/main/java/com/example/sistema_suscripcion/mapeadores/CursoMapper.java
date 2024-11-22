package com.example.sistema_suscripcion.mapeadores;

import com.example.sistema_suscripcion.DTOs.CursoDTO;
import com.example.sistema_suscripcion.entidades.Curso;
import org.springframework.stereotype.Component;

@Component
public class CursoMapper {

    public CursoDTO toDto(Curso curso) {
        CursoDTO dto = new CursoDTO();
        dto.setId(curso.getId());
        dto.setNombre(curso.getNombre());
        dto.setDescripcion(curso.getDescripcion());
        dto.setEstado(curso.getEstado());
        dto.setCreadorId(curso.getCreador().getId());
        return dto;
    }

    public Curso toEntity(CursoDTO dto) {
        Curso curso = new Curso();
        curso.setId(dto.getId());
        curso.setNombre(dto.getNombre());
        curso.setDescripcion(dto.getDescripcion());
        curso.setEstado(dto.getEstado());
        return curso;
    }
}
