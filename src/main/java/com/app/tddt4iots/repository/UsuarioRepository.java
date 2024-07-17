package com.app.tddt4iots.repository;
 
 import com.app.tddt4iots.entities.Usuario;
 import org.springframework.data.jpa.repository.JpaRepository;
 import java.util.*;
import java.lang.*;

 public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
 }
