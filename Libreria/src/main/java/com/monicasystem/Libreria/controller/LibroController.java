package com.monicasystem.Libreria.controller;

import com.monicasystem.Libreria.entity.Libro;
import com.monicasystem.Libreria.service.LibroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    // Listar libros
    @GetMapping
    public List<Libro> listar() {
        return libroService.listarLibros();
    }

    // Buscar libro por ID
    @GetMapping("/{id}")
    public Optional<Libro> buscarPorId(@PathVariable Long id) {
        return libroService.buscarPorId(id);
    }

    // Guardar nuevo libro
    @PostMapping
    public Libro guardar(@RequestBody Libro libro) {
        return libroService.guardarLibro(libro);
    }

    // Actualizar libro
    @PutMapping("/{id}")
    public Libro actualizar(@PathVariable Long id, @RequestBody Libro libro) {
        libro.setId(id);
        return libroService.guardarLibro(libro);
    }

    // Eliminar libro
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        libroService.eliminarLibro(id);
    }
}



