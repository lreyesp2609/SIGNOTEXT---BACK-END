package com.app.tddt4iots.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "ConfiguracionCamara")
@Data
@NoArgsConstructor
public class ConfiguracionCamara {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Column(name = "idConfiguracion", nullable = true, unique = true, length = 30) 
    private String idConfiguracion; 
 
    @Column(name = "nombreConfiguracion", nullable = false, length = 30) 
    private String nombreConfiguracion; 
 
    @Column(name = "ConfigurarCamara", nullable = false, length = 30) 
    private String configurarCamara;  // Renombrado a `configurarCamara` para seguir convención de nombres

    @OneToMany(mappedBy = "configuracionCamara") 
    private List<Camara> camaras;  // Corregido a `camaras` para seguir convención de nombres y `mappedBy` corregido

}
