package com.monicasystem.Libreria.service;


import com.monicasystem.Libreria.entity.Libro;
import com.monicasystem.Libreria.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    // Guardar o actualizar libro
    public Libro guardarLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    // Listar libros
    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    // Buscar libro por ID
    public Optional<Libro> buscarPorId(Long id) {
        return libroRepository.findById(id);
    }

    // Eliminar libro
    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }
}



