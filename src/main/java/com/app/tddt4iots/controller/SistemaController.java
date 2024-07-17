package com.app.tddt4iots.controller;

import com.app.tddt4iots.entities.Sistema;
import com.app.tddt4iots.repository.SistemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sistema")
public class SistemaController {

    @Autowired
    private SistemaRepository sistemaRepository;

    @GetMapping
    public ResponseEntity<List<Sistema>> getSistema() {
        List<Sistema> listSistema = sistemaRepository.findAll();
        return ResponseEntity.ok(listSistema);
    }

    @PostMapping
    public ResponseEntity<Sistema> insertSistema(@RequestBody Sistema sistema) {
        Sistema newSistema = sistemaRepository.save(sistema);
        return ResponseEntity.ok(newSistema);
    }

    @PutMapping
    public ResponseEntity<Sistema> updateSistema(@RequestBody Sistema sistema) {
        Sistema upSistema = sistemaRepository.save(sistema);
        if (upSistema != null) {
            return ResponseEntity.ok(upSistema);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Sistema> deletePersons(@PathVariable("id") Long id) {
        sistemaRepository.deleteById(id);
        return ResponseEntity.ok(null);
    }

}
