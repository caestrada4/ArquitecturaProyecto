package com.example.sistema_suscripcion.mapeadores;

import com.example.sistema_suscripcion.DTOs.SuscripcionDTO;
import com.example.sistema_suscripcion.entidades.Suscripcion;
import org.springframework.stereotype.Component;

@Component
public class SuscripcionMapper {

    public SuscripcionDTO toDto(Suscripcion suscripcion) {
        SuscripcionDTO dto = new SuscripcionDTO();
        dto.setId(suscripcion.getId());
        dto.setUsuarioId(suscripcion.getUsuario().getId());
        dto.setCursoId(suscripcion.getCurso().getId());
        dto.setFechaSuscripcion(suscripcion.getFechaSuscripcion());
        return dto;
    }


    public Suscripcion toEntity(SuscripcionDTO dto) {
        Suscripcion suscripcion = new Suscripcion();
        suscripcion.setId(dto.getId());
        // Si necesitas asignar la fecha desde el DTO:
        suscripcion.setFechaSuscripcion(dto.getFechaSuscripcion());
        return suscripcion;
    }

}
