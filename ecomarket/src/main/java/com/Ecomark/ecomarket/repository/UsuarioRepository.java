package com.Ecomark.ecomarket.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ecomark.ecomarket.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
        List<Usuario> findAll();   
        Optional<Usuario> findByEmailUsuario(String email_usuario);
    boolean existsByEmailUsuario(String email_usuario);
}
