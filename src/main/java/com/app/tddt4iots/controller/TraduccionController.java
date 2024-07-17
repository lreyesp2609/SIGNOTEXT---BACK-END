package com.app.tddt4iots.controller;

import com.app.tddt4iots.entities.Traduccion;
import com.app.tddt4iots.repository.TraduccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/traduccion")
public class TraduccionController {

    @Autowired
    private TraduccionRepository traduccionRepository;

    @GetMapping
    public ResponseEntity<List<Traduccion>> getTraduccion() {
        List<Traduccion> listTraduccion = traduccionRepository.findAll();
        return ResponseEntity.ok(listTraduccion);
    }

    @PostMapping
    public ResponseEntity<Traduccion> insertTraduccion(@RequestBody Traduccion traduccion) {
        Traduccion newTraduccion = traduccionRepository.save(traduccion);
        return ResponseEntity.ok(newTraduccion);
    }

    @PutMapping
    public ResponseEntity<Traduccion> updateTraduccion(@RequestBody Traduccion traduccion) {
        Traduccion upTraduccion = traduccionRepository.save(traduccion);
        if (upTraduccion != null) {
            return ResponseEntity.ok(upTraduccion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Traduccion> deletePersons(@PathVariable("id") Long id) {
        traduccionRepository.deleteById(id);
        return ResponseEntity.ok(null);
    }

}
