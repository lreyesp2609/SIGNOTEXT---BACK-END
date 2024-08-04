package com.app.tddt4iots.service.impl;

import com.app.tddt4iots.service.UsuarioService;
import com.app.tddt4iots.repository.UsuarioRepository;
import com.app.tddt4iots.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        // Generar el nombre de usuario base
        String nombreUsuarioBase = generarNombreUsuario(usuario.getNombres(), usuario.getApellidos());

        // Verificar y generar un nombre de usuario único
        String nombreUsuarioUnico = obtenerNombreUsuarioUnico(nombreUsuarioBase);

        usuario.setUsuario(nombreUsuarioUnico);
        return usuarioRepository.save(usuario);
    }

    private String generarNombreUsuario(String nombres, String apellidos) {
        String[] nombreArray = nombres.trim().split(" ");
        String[] apellidoArray = apellidos.trim().split(" ");

        String nombreUsuario = nombreArray[0].toLowerCase() + "." + apellidoArray[0].toLowerCase();
        return nombreUsuario;
    }

    private String obtenerNombreUsuarioUnico(String nombreUsuarioBase) {
        String nombreUsuarioUnico = nombreUsuarioBase;
        int contador = 1;

        while (usuarioRepository.existsByUsuario(nombreUsuarioUnico)) {
            nombreUsuarioUnico = nombreUsuarioBase + contador++;
        }

        return nombreUsuarioUnico;
    }

    @Override
    public Usuario autenticarUsuario(String usuario, String contrasena) {
        Usuario usuarioEncontrado = usuarioRepository.findByUsuario(usuario);
        if (usuarioEncontrado != null && passwordEncoder.matches(contrasena, usuarioEncontrado.getContrasena())) {
            return usuarioEncontrado;
        }
        return null;
    }
}
