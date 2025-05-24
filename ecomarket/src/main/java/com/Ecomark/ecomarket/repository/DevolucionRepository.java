package com.Ecomark.ecomarket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ecomark.ecomarket.model.Devolucion;

@Repository
public interface DevolucionRepository extends JpaRepository<Devolucion,Long> {
    List<Devolucion> findByClienteId(Long clienteId);
    
}