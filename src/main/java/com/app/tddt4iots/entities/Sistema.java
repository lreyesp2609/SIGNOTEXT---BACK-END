package com.app.tddt4iots.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Sistema")
@Data
@NoArgsConstructor
public class Sistema {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Cambiado a Identity para PostgreSQL
    private Long id;

    @Column(name = "estado", nullable = false, length = 30) 
    private String estado; 

    @Column(name = "verificarEstado", nullable = false) 
    private Boolean verificarEstado; 

    @OneToOne(fetch = FetchType.LAZY)  // Asegúrate de incluir FetchType.LAZY
    @JoinColumn(name = "idCamara", referencedColumnName = "id") 
    private Camara camara; 

    @OneToMany(mappedBy = "sistema", fetch = FetchType.LAZY)  // Asegúrate de mapear por la relación correcta
    private List<Gestos> gestos; 

    @OneToMany(mappedBy = "sistema", fetch = FetchType.LAZY)  // Asegúrate de mapear por la relación correcta
    private List<Traduccion> traducciones;

    @Column(name = "detectarActualizacion", nullable = false) 
    private Boolean detectarActualizacion; 

    @Column(name = "descargarActualizacion", nullable = false) 
    private Boolean descargarActualizacion; 

    @Column(name = "verificarIntegridad", nullable = false) 
    private Boolean verificarIntegridad; 

    @Column(name = "actualizarDiccionario", nullable = false, length = 30) 
    private String actualizarDiccionario; 

    @Column(name = "notificarActualizacion", nullable = false, length = 30) 
    private String notificarActualizacion; 
}
