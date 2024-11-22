package com.example.sistema_suscripcion.servicios;

import com.example.sistema_suscripcion.DTOs.CursoDTO;
import com.example.sistema_suscripcion.entidades.Curso;

import com.example.sistema_suscripcion.excepciones.RecursoNoEncontradoExcepcion;
import com.example.sistema_suscripcion.mapeadores.CursoMapper;
import com.example.sistema_suscripcion.repositorios.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;
    private final CursoMapper cursoMapper;

    public CursoService(CursoRepository cursoRepository, CursoMapper cursoMapper) {
        this.cursoRepository = cursoRepository;
        this.cursoMapper = cursoMapper;
    }

    public List<CursoDTO> obtenerTodosLosCursos() {
        return cursoRepository.findAll().stream()
                .map(cursoMapper::toDto)
                .collect(Collectors.toList());
    }

    public CursoDTO crearCurso(CursoDTO cursoDTO) {
        Curso curso = cursoMapper.toEntity(cursoDTO);
        Curso cursoGuardado = cursoRepository.save(curso);
        return cursoMapper.toDto(cursoGuardado);
    }

    public CursoDTO modificarCurso(Long id, CursoDTO cursoDTO) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow();
        curso.setNombre(cursoDTO.getNombre());
        curso.setDescripcion(cursoDTO.getDescripcion());
        curso.setEstado(cursoDTO.getEstado());
        Curso cursoActualizado = cursoRepository.save(curso);
        return cursoMapper.toDto(cursoActualizado);
    }

    public void eliminarCurso(Long id) throws RecursoNoEncontradoExcepcion {
        if (!cursoRepository.existsById(id)) {
            throw new RecursoNoEncontradoExcepcion("Curso no encontrado con ID: " + id);
        }
        cursoRepository.deleteById(id);
    }
}
