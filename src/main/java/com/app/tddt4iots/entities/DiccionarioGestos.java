package com.app.tddt4iots.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "DiccionarioGestos")
@Data
@NoArgsConstructor
public class DiccionarioGestos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "actualizarDiccionario", nullable = false, length = 30)
    private String actualizarDiccionario;

    @OneToMany(mappedBy = "diccionarioGestos")
    private List<Gestos> gestos;
}
