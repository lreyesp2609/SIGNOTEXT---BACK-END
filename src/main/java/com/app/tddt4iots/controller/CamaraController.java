package com.app.tddt4iots.controller;

import com.app.tddt4iots.entities.Camara;
import com.app.tddt4iots.repository.CamaraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/camara")
public class CamaraController {

    @Autowired
    private CamaraRepository camaraRepository;

    @GetMapping
    public ResponseEntity<List<Camara>> getCamara() {
        List<Camara> listCamara = camaraRepository.findAll();
        return ResponseEntity.ok(listCamara);
    }

    @PostMapping
    public ResponseEntity<Camara> insertCamara(@RequestBody Camara camara) {
        Camara newCamara = camaraRepository.save(camara);
        return ResponseEntity.ok(newCamara);
    }

    @PutMapping
    public ResponseEntity<Camara> updateCamara(@RequestBody Camara camara) {
        Camara upCamara = camaraRepository.save(camara);
        if (upCamara != null) {
            return ResponseEntity.ok(upCamara);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Camara> deletePersons(@PathVariable("id") Long id) {
        camaraRepository.deleteById(id);
        return ResponseEntity.ok(null);
    }

}
