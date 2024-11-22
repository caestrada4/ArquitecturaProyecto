package com.example.sistema_suscripcion.repositorios;

import com.example.sistema_suscripcion.entidades.Suscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuscripcionRepository extends JpaRepository<Suscripcion, Long> {
}
