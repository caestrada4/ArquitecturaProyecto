package com.example.sistema_suscripcion.servicios;


import com.example.sistema_suscripcion.DTOs.SuscripcionDTO;
import com.example.sistema_suscripcion.entidades.Suscripcion;
import com.example.sistema_suscripcion.excepciones.RecursoNoEncontradoExcepcion;
import com.example.sistema_suscripcion.mapeadores.SuscripcionMapper;
import com.example.sistema_suscripcion.repositorios.SuscripcionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SuscripcionService {

    private final SuscripcionRepository suscripcionRepository;
    private final SuscripcionMapper suscripcionMapper;

    public SuscripcionService(SuscripcionRepository suscripcionRepository, SuscripcionMapper suscripcionMapper) {
        this.suscripcionRepository = suscripcionRepository;
        this.suscripcionMapper = suscripcionMapper;
    }

    public List<SuscripcionDTO> obtenerTodasLasSuscripciones() {
        return suscripcionRepository.findAll().stream()
                .map(suscripcionMapper::toDto)
                .collect(Collectors.toList());
    }

    public SuscripcionDTO crearSuscripcion(SuscripcionDTO suscripcionDTO) {
        Suscripcion suscripcion = suscripcionMapper.toEntity(suscripcionDTO);
        Suscripcion suscripcionGuardada = suscripcionRepository.save(suscripcion);
        return suscripcionMapper.toDto(suscripcionGuardada);
    }

    public void eliminarSuscripcion(Long id) {
        if (!suscripcionRepository.existsById(id)) {
            throw new RecursoNoEncontradoExcepcion("Suscripción no encontrada con ID: " + id);
        }
        suscripcionRepository.deleteById(id);
    }
}
