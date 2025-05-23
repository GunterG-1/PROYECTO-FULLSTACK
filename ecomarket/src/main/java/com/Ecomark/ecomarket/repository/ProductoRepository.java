package com.Ecomark.ecomarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ecomark.ecomarket.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository <Producto, Long> {
    boolean existsByCodigo(int codigo);

}
