package com.monicasystem.Persona.controller;


import com.monicasystem.Persona.entity.Persona;
import com.monicasystem.Persona.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persona")
public class PersonaController {

    @Autowired
    private PersonaRepository personaRepository;

    // Listar todas las personas
    @GetMapping
    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }

    // Crear persona
    @PostMapping
    public Persona createPersona(@RequestBody Persona persona) {
        return personaRepository.save(persona);
    }

    // Buscar persona por ID
    @GetMapping("/{id}")
    public Persona getPersonaById(@PathVariable Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    // Actualizar persona
    @PutMapping("/{id}")
    public Persona updatePersona(@PathVariable Long id, @RequestBody Persona personaDetalles) {
        Persona persona = personaRepository.findById(id).orElse(null);
        if (persona != null) {
            persona.setNombre(personaDetalles.getNombre());
            persona.setApellido(personaDetalles.getApellido());
            persona.setEdad(personaDetalles.getEdad());
            return personaRepository.save(persona);
        }
        return null;
    }

    // Eliminar persona
    @DeleteMapping("/{id}")
    public String deletePersona(@PathVariable Long id) {
        personaRepository.deleteById(id);
        return "Persona eliminada con éxito";
    }
}
