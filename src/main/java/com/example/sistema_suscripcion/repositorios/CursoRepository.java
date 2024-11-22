package com.example.sistema_suscripcion.repositorios;

import com.example.sistema_suscripcion.entidades.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
