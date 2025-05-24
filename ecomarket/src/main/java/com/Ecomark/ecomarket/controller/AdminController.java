package com.Ecomark.ecomarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

import com.Ecomark.ecomarket.model.Usuario;
import com.Ecomark.ecomarket.service.AdminService;


@RestController
@RequestMapping("/api/admin/usuarios")

public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public List<Usuario>findall(){
        return adminService.findAll();
    }
    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return adminService.save(usuario);
}
    
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
        try{
            Usuario usu = adminService.findById(id);
            usu.setId(id);
            usu.setNom_usuario(usu.getNom_usuario());
            usu.setAp_usuario(usu.getAp_usuario());
            usu.setEmailUsuario(usu.getEmailUsuario());
            usu.setDir_usuario(usu.getDir_usuario());
            usu.setMetodoPago(usu.getMetodoPago());
            
            adminService.save(usuario);
            return ResponseEntity.ok(usuario);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}/desactivar")
    public ResponseEntity<Void> desactivar(@PathVariable Long id) {
        adminService.desactivarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}/eliminar")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        adminService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}

