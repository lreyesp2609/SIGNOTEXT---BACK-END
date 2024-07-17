package com.app.tddt4iots.controller;

import com.app.tddt4iots.entities.ConfiguracionCamara;
import com.app.tddt4iots.repository.ConfiguracionCamaraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/configuracioncamara")
public class ConfiguracionCamaraController {

    @Autowired
    private ConfiguracionCamaraRepository configuracioncamaraRepository;

    @GetMapping
    public ResponseEntity<List<ConfiguracionCamara>> getConfiguracionCamara() {
        List<ConfiguracionCamara> listConfiguracionCamara = configuracioncamaraRepository.findAll();
        return ResponseEntity.ok(listConfiguracionCamara);
    }

    @PostMapping
    public ResponseEntity<ConfiguracionCamara> insertConfiguracionCamara(@RequestBody ConfiguracionCamara configuracioncamara) {
        ConfiguracionCamara newConfiguracionCamara = configuracioncamaraRepository.save(configuracioncamara);
        return ResponseEntity.ok(newConfiguracionCamara);
    }

    @PutMapping
    public ResponseEntity<ConfiguracionCamara> updateConfiguracionCamara(@RequestBody ConfiguracionCamara configuracioncamara) {
        ConfiguracionCamara upConfiguracionCamara = configuracioncamaraRepository.save(configuracioncamara);
        if (upConfiguracionCamara != null) {
            return ResponseEntity.ok(upConfiguracionCamara);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<ConfiguracionCamara> deletePersons(@PathVariable("id") Long id) {
        configuracioncamaraRepository.deleteById(id);
        return ResponseEntity.ok(null);
    }

}
