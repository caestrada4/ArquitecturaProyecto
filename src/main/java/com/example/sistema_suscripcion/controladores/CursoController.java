package com.example.sistema_suscripcion.controladores;

import com.example.sistema_suscripcion.DTOs.CursoDTO;
import com.example.sistema_suscripcion.excepciones.RecursoNoEncontradoExcepcion;
import com.example.sistema_suscripcion.servicios.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public ResponseEntity<List<CursoDTO>> obtenerTodosLosCursos() {
        return ResponseEntity.ok(cursoService.obtenerTodosLosCursos());
    }

    @PostMapping
    public ResponseEntity<CursoDTO> crearCurso(@RequestBody CursoDTO cursoDTO) {
        return ResponseEntity.ok(cursoService.crearCurso(cursoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDTO> modificarCurso(@PathVariable Long id, @RequestBody CursoDTO cursoDTO) {
        return ResponseEntity.ok(cursoService.modificarCurso(id, cursoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable Long id) throws RecursoNoEncontradoExcepcion {
        cursoService.eliminarCurso(id);
        return ResponseEntity.noContent().build();
    }
}
