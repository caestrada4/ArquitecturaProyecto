package com.example.sistema_suscripcion.DTOs;

import com.example.sistema_suscripcion.entidades.Curso.EstadoCurso;
import lombok.Data;

@Data
public class CursoDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private EstadoCurso estado;
    private Long creadorId;
}