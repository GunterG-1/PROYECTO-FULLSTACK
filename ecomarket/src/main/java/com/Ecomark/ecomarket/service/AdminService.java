package com.Ecomark.ecomarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecomark.ecomarket.model.Usuario;

import com.Ecomark.ecomarket.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AdminService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();

    }
    public Usuario creUsuario(String nombre, String email, String contrasena) {
    if (usuarioRepository.existsByEmailUsuario(email)) {
        throw new RuntimeException("El email ya está en uso");
    }
    Usuario nuevo = new Usuario();
    nuevo.setNom_usuario(nombre);
    nuevo.setEmailUsuario(email);
    nuevo.setContraseña_usuario(contrasena); 
    nuevo.setActivo(true);
    return usuarioRepository.save(nuevo);
    
}
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    public void desactivarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setActivo(false);
        usuarioRepository.save(usuario);
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
}
}