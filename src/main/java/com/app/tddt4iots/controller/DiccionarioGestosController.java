package com.app.tddt4iots.controller;

import com.app.tddt4iots.entities.DiccionarioGestos;
import com.app.tddt4iots.repository.DiccionarioGestosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/diccionariogestos")
public class DiccionarioGestosController {

    @Autowired
    private DiccionarioGestosRepository diccionariogestosRepository;

    @GetMapping
    public ResponseEntity<List<DiccionarioGestos>> getDiccionarioGestos() {
        List<DiccionarioGestos> listDiccionarioGestos = diccionariogestosRepository.findAll();
        return ResponseEntity.ok(listDiccionarioGestos);
    }

    @PostMapping
    public ResponseEntity<DiccionarioGestos> insertDiccionarioGestos(@RequestBody DiccionarioGestos diccionariogestos) {
        DiccionarioGestos newDiccionarioGestos = diccionariogestosRepository.save(diccionariogestos);
        return ResponseEntity.ok(newDiccionarioGestos);
    }

    @PutMapping
    public ResponseEntity<DiccionarioGestos> updateDiccionarioGestos(@RequestBody DiccionarioGestos diccionariogestos) {
        DiccionarioGestos upDiccionarioGestos = diccionariogestosRepository.save(diccionariogestos);
        if (upDiccionarioGestos != null) {
            return ResponseEntity.ok(upDiccionarioGestos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<DiccionarioGestos> deletePersons(@PathVariable("id") Long id) {
        diccionariogestosRepository.deleteById(id);
        return ResponseEntity.ok(null);
    }

}
