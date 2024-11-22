package com.example.sistema_suscripcion.controladores;

import com.example.sistema_suscripcion.DTOs.SuscripcionDTO;
import com.example.sistema_suscripcion.servicios.SuscripcionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suscripciones")
public class SuscripcionController {

    private final SuscripcionService suscripcionService;

    public SuscripcionController(SuscripcionService suscripcionService) {
        this.suscripcionService = suscripcionService;
    }

    @GetMapping
    public ResponseEntity<List<SuscripcionDTO>> obtenerTodasLasSuscripciones() {
        return ResponseEntity.ok(suscripcionService.obtenerTodasLasSuscripciones());
    }

    @PostMapping
    public ResponseEntity<SuscripcionDTO> crearSuscripcion(@RequestBody SuscripcionDTO suscripcionDTO) {
        return ResponseEntity.ok(suscripcionService.crearSuscripcion(suscripcionDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSuscripcion(@PathVariable Long id) {
        suscripcionService.eliminarSuscripcion(id);
        return ResponseEntity.noContent().build();
    }
}
