package com.app.tddt4iots.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Usuario")
@Data
@NoArgsConstructor
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Column(name = "usuario", nullable = true, unique = true, length = 30)
    private String usuario; 
 
    @Column(name = "nombres", nullable = false, length = 30) 
    private String nombres;
    
    @Column(name = "apellidos", nullable = true, length = 50)
    private String apellidos; 
 
    @Column(name = "email", nullable = false, unique = true, length = 50)
    private String email;

    @Column(name = "contrasena", nullable = false, length = 60)
    private String contrasena;

    @Column(name = "rol", nullable = false, length = 30) 
    private String rol; 
 
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Traduccion> traducciones;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idHistorial", referencedColumnName = "id") 
    private Historial historial; 
}
