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
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Cambiado a Identity para PostgreSQL
    private Long id;
 
    @Column(name = "idUsuario", nullable = true, unique = true, length = 30) 
    private String idUsuario; 
 
    @Column(name = "nombre", nullable = false, length = 30) 
    private String nombre; 
 
    @Column(name = "email", nullable = false, unique = true, length = 50)  // Aumentado el tamaño del email
    private String email; 
 
    @Column(name = "rol", nullable = false, length = 30) 
    private String rol; 
 
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)  // Corregido para mapear correctamente con Traduccion
    private List<Traduccion> traducciones;  // Renombrado a traducciones para pluralidad

    @OneToOne(fetch = FetchType.LAZY)  // Asegúrate de incluir FetchType.LAZY
    @JoinColumn(name = "idHistorial", referencedColumnName = "id") 
    private Historial historial; 
}
