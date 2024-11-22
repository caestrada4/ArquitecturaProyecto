package com.example.sistema_suscripcion.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombres;
    private String apellidos;
    private String email;
    private String contraseña;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    public enum TipoUsuario {
        ADMIN,
        CREATOR,
        CONSUMER
    }

}
