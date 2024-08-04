package com.app.tddt4iots.controller;

import com.app.tddt4iots.entities.Usuario;
import com.app.tddt4iots.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarUsuario(
        @RequestParam("nombres") String nombres,
        @RequestParam("apellidos") String apellidos,
        @RequestParam("email") String email,
        @RequestParam("rol") String rol,
        @RequestParam("contrasena") String contrasena) {

        String usuario = generarNombreUsuario(nombres, apellidos);

        String contrasenaEncriptada = passwordEncoder.encode(contrasena);

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setUsuario(usuario);
        nuevoUsuario.setNombres(nombres);
        nuevoUsuario.setApellidos(apellidos);
        nuevoUsuario.setEmail(email);
        nuevoUsuario.setRol(rol);
        nuevoUsuario.setContrasena(contrasenaEncriptada);

        usuarioService.registrarUsuario(nuevoUsuario);

        String mensaje = "Se creó correctamente el usuario con nombre de usuario: " + usuario;
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(
        @RequestParam("usuario") String usuario,
        @RequestParam("contrasena") String contrasena) {

        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuario, contrasena)
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);

            Usuario usuarioAutenticado = (Usuario) authentication.getPrincipal();
            String nombreCompleto = usuarioAutenticado.getNombres() + " " + usuarioAutenticado.getApellidos();
            return new ResponseEntity<>("Usuario autenticado: " + nombreCompleto, HttpStatus.OK);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>("Credenciales inválidas", HttpStatus.UNAUTHORIZED);
        }
    }

    private String generarNombreUsuario(String nombres, String apellidos) {
        String[] nombreArray = nombres.split(" ");
        String[] apellidoArray = apellidos.split(" ");
        
        return nombreArray[0].toLowerCase() + "." + apellidoArray[0].toLowerCase();
    }
}
