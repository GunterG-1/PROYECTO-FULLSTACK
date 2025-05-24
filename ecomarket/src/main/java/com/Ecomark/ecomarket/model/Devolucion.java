package com.Ecomark.ecomarket.model;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "devolucion")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Devolucion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,length = 200,nullable = false)
    private String motivo;
    
    private Long productoId;

    @Column (nullable = true)
    @Temporal(TemporalType.DATE)
    private Date fechaDevolucion;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;

    private String estado; // Ej: "Pendiente", "Procesada"

}