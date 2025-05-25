package com.Ecomark.ecomarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ecomark.ecomarket.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol,Long>{
}