package com.app.tddt4iots.controller;

import com.app.tddt4iots.dto.UsuarioResponse;
import com.app.tddt4iots.entities.Usuario;
import com.app.tddt4iots.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarUsuario(
        @RequestParam("nombres") String nombres,
        @RequestParam("apellidos") String apellidos,
        @RequestParam("email") String email,
        @RequestParam("rol") String rol,
        @RequestParam("contrasena") String contrasena) {

        // Crear un nuevo Usuario
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombres(nombres);
        nuevoUsuario.setApellidos(apellidos);
        nuevoUsuario.setEmail(email);
        nuevoUsuario.setRol(rol);
        nuevoUsuario.setContrasena(passwordEncoder.encode(contrasena));

        // Registrar el usuario
        Usuario usuarioRegistrado = usuarioService.registrarUsuario(nuevoUsuario);

        String mensaje = "Se creó correctamente el usuario con nombre de usuario: " + usuarioRegistrado.getUsuario();
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam("usuario") String usuario, @RequestParam("contrasena") String contrasena) {
        Usuario usuarioAutenticado = usuarioService.autenticarUsuario(usuario, contrasena);
        if (usuarioAutenticado != null) {
            UsuarioResponse response = new UsuarioResponse(
                usuarioAutenticado.getId(),
                usuarioAutenticado.getNombres(),
                usuarioAutenticado.getApellidos()
            );
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }
}
