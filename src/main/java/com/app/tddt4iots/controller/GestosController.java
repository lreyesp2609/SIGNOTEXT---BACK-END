package com.app.tddt4iots.controller;

import com.app.tddt4iots.entities.Gestos;
import com.app.tddt4iots.repository.GestosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gestos")
public class GestosController {

    @Autowired
    private GestosRepository gestosRepository;

    @GetMapping
    public ResponseEntity<List<Gestos>> getGestos() {
        List<Gestos> listGestos = gestosRepository.findAll();
        return ResponseEntity.ok(listGestos);
    }

    @PostMapping
    public ResponseEntity<Gestos> insertGestos(@RequestBody Gestos gestos) {
        Gestos newGestos = gestosRepository.save(gestos);
        return ResponseEntity.ok(newGestos);
    }

    @PutMapping
    public ResponseEntity<Gestos> updateGestos(@RequestBody Gestos gestos) {
        Gestos upGestos = gestosRepository.save(gestos);
        if (upGestos != null) {
            return ResponseEntity.ok(upGestos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Gestos> deletePersons(@PathVariable("id") Long id) {
        gestosRepository.deleteById(id);
        return ResponseEntity.ok(null);
    }

}
