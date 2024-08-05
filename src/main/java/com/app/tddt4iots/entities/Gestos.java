package com.app.tddt4iots.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Entity
@Table(name = "Gestos")
@Data
@NoArgsConstructor
public class Gestos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descripcion", nullable = false, length = 30) 
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idSistema", referencedColumnName = "id")
    private Sistema sistema;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDiccionarioGestos", referencedColumnName = "id")
    private DiccionarioGestos diccionarioGestos;
}
