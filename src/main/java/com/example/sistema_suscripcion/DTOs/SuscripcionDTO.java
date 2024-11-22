package com.example.sistema_suscripcion.DTOs;

import java.time.LocalDateTime;

public class SuscripcionDTO {
    private Long id;
    private Long usuarioId;
    private Long cursoId;
    private LocalDateTime fechaSuscripcion;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

    public LocalDateTime getFechaSuscripcion() {
        return fechaSuscripcion;
    }

    public void setFechaSuscripcion(LocalDateTime fechaSuscripcion) {
        this.fechaSuscripcion = fechaSuscripcion;
    }
}
