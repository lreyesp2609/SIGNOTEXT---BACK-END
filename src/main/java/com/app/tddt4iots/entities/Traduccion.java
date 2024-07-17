package com.app.tddt4iots.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Entity
@Table(name = "Traduccion")
@Data
@NoArgsConstructor
public class Traduccion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Cambiado a Identity para PostgreSQL
    private Long id;

    @Column(name = "idTraduccion", nullable = true, unique = true, length = 30) 
    private String idTraduccion; 

    @Column(name = "textoTraducido", nullable = false, length = 100)  // Aumentado el tamaño del texto
    private String textoTraducido; 

    @Column(name = "fechaHora", nullable = false, length = 30) 
    private String fechaHora; 

    @Column(name = "mostrar", nullable = false, length = 30) 
    private String mostrar; 

    @ManyToOne(fetch = FetchType.LAZY)  // Asegúrate de incluir FetchType.LAZY
    @JoinColumn(name = "idSistema", referencedColumnName = "id") 
    private Sistema sistema; 

    @ManyToOne(fetch = FetchType.LAZY)  // Asegúrate de incluir FetchType.LAZY
    @JoinColumn(name = "idUsuario", referencedColumnName = "id") 
    private Usuario usuario; 

    @ManyToOne(fetch = FetchType.LAZY)  // Asegúrate de incluir FetchType.LAZY
    @JoinColumn(name = "idHistorial", referencedColumnName = "id") 
    private Historial historial; 
}
