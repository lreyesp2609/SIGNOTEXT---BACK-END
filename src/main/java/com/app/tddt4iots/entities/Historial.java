package com.app.tddt4iots.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Historial")
@Data
@NoArgsConstructor
public class Historial {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Cambiado a Identity para PostgreSQL
    private Long id;
    
    @Column(name = "idHistorial", nullable = true, unique = true, length = 30) 
    private String idHistorial; 

    @Column(name = "idUsuario", nullable = true, unique = false, length = 30) 
    private String idUsuario; 

    @Column(name = "traducciones", nullable = false, length = 30) 
    private String traducciones; 

    @Column(name = "obtenerTraducciones", nullable = false, length = 30) 
    private String obtenerTraducciones; 

    @Column(name = "agregarTraduccion", nullable = false, length = 30) 
    private String agregarTraduccion; 

    @Column(name = "eliminarTraduccion", nullable = false, length = 30) 
    private String eliminarTraduccion; 

    @Column(name = "mostrarHistorial", nullable = false, length = 30) 
    private String mostrarHistorial; 

    @OneToOne(fetch = FetchType.LAZY) // Asegúrate de incluir FetchType.LAZY
    @JoinColumn(name = "idUsuario", referencedColumnName = "id", insertable = false, updatable = false) 
    private Usuario usuario;

    @OneToMany(mappedBy = "historial", fetch = FetchType.LAZY)  // Asegúrate de mapear por la relación correcta
    private List<Traduccion> traduccions;
}
