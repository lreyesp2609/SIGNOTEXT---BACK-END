package com.app.tddt4iots.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Entity
@Table(name = "Camara")
@Data
@NoArgsConstructor
public class Camara {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "idCamara", nullable = true, unique = true, length = 30) 
    private String idCamara; 
 
    @Column(name = "estado", nullable = false, length = 30) 
    private String estado; 
 
    @Column(name = "verificarEstado", nullable = false) 
    private Boolean verificarEstado; 
 
    @OneToOne
    @JoinColumn(name = "idSistema", referencedColumnName = "id") 
    private Sistema sistema; 
 
    @ManyToOne
    @JoinColumn(name = "idConfiguracionCamara", referencedColumnName = "id") 
    private ConfiguracionCamara configuracionCamara; 

}
