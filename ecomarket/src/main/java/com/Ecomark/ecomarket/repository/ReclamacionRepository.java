package com.Ecomark.ecomarket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Ecomark.ecomarket.model.Reclamacion;

@Repository
public interface ReclamacionRepository extends JpaRepository<Reclamacion, Long> {
    List<Reclamacion> findByClienteId(Long clienteId);
}