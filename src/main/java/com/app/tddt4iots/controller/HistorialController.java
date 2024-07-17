package com.app.tddt4iots.controller;

import com.app.tddt4iots.entities.Historial;
import com.app.tddt4iots.repository.HistorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/historial")
public class HistorialController {

    @Autowired
    private HistorialRepository historialRepository;

    @GetMapping
    public ResponseEntity<List<Historial>> getHistorial() {
        List<Historial> listHistorial = historialRepository.findAll();
        return ResponseEntity.ok(listHistorial);
    }

    @PostMapping
    public ResponseEntity<Historial> insertHistorial(@RequestBody Historial historial) {
        Historial newHistorial = historialRepository.save(historial);
        return ResponseEntity.ok(newHistorial);
    }

    @PutMapping
    public ResponseEntity<Historial> updateHistorial(@RequestBody Historial historial) {
        Historial upHistorial = historialRepository.save(historial);
        if (upHistorial != null) {
            return ResponseEntity.ok(upHistorial);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Historial> deletePersons(@PathVariable("id") Long id) {
        historialRepository.deleteById(id);
        return ResponseEntity.ok(null);
    }

}
