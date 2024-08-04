package com.app.tddt4iots.service.impl;

import com.app.tddt4iots.service.UsuarioService;
import com.app.tddt4iots.repository.UsuarioRepository;
import com.app.tddt4iots.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        String nombreUsuario = usuario.getUsuario();
        while (usuarioRepository.existsByUsuario(nombreUsuario)) {
            nombreUsuario = generarNombreUsuarioUnico(nombreUsuario);
        }
        usuario.setUsuario(nombreUsuario);
        return usuarioRepository.save(usuario);
    }

    private String generarNombreUsuarioUnico(String nombreUsuario) {
        return nombreUsuario + (int) (Math.random() * 1000);
    }
}
