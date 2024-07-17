package com.app.tddt4iots.controller;

import com.app.tddt4iots.entities.Usuario;
import com.app.tddt4iots.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuario() {
        List<Usuario> listUsuario = usuarioRepository.findAll();
        return ResponseEntity.ok(listUsuario);
    }

    @PostMapping
    public ResponseEntity<Usuario> insertUsuario(@RequestBody Usuario usuario) {
        Usuario newUsuario = usuarioRepository.save(usuario);
        return ResponseEntity.ok(newUsuario);
    }

    @PutMapping
    public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario) {
        Usuario upUsuario = usuarioRepository.save(usuario);
        if (upUsuario != null) {
            return ResponseEntity.ok(upUsuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Usuario> deletePersons(@PathVariable("id") Long id) {
        usuarioRepository.deleteById(id);
        return ResponseEntity.ok(null);
    }

}
