package com.example.sistema_suscripcion.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;

    @Enumerated(EnumType.STRING)
    private EstadoCurso estado;

    @ManyToOne
    @JoinColumn(name = "creador_id")
    private Usuario creador;

    public enum EstadoCurso {
        EN_CONSTRUCCION, ACTIVO, INACTIVO
    }
}
