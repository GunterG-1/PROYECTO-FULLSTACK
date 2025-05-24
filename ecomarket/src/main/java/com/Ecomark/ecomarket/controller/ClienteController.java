package com.Ecomark.ecomarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Ecomark.ecomarket.model.Devolucion;
import com.Ecomark.ecomarket.model.Reclamacion;
import com.Ecomark.ecomarket.model.Usuario;
import com.Ecomark.ecomarket.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class ClienteController {

    @Autowired
    private  UsuarioService usuarioService;

     @PostMapping("/registrar")
    public ResponseEntity<Usuario> registrar(@RequestBody Usuario usuario) {
        try{
        Usuario nuevaUsuario = usuarioService.registrarCliente(usuario.getNom_usuario(), usuario.getEmailUsuario(), usuario.getContraseña_usuario());
        return ResponseEntity.ok(nuevaUsuario);
    }catch(Exception e){
        return ResponseEntity.badRequest().build();
    }
}
@PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody  Usuario usuario) {
        try{
        Usuario loginUsuario = usuarioService.autenticar(usuario.getEmailUsuario(), usuario.getContraseña_usuario());
        return ResponseEntity.ok(loginUsuario);
}catch(Exception e ){
    return ResponseEntity.badRequest().build();
}
}
@PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
        try{
            Usuario usu = usuarioService.findById(id);
            usu.setId(id);
            usu.setNom_usuario(usu.getNom_usuario());
            usu.setAp_usuario(usu.getAp_usuario());
            usu.setEmailUsuario(usu.getEmailUsuario());
            usu.setDir_usuario(usu.getDir_usuario());
            usu.setMetodoPago(usu.getMetodoPago());
            
            usuarioService.save(usuario);
            return ResponseEntity.ok(usuario);
        }catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
     
    @PostMapping("/{id}/reclamos")
    public ResponseEntity<Reclamacion> registrarReclamo(
            @PathVariable Long id,
            @RequestParam String asunto,
            @RequestParam String descripcion) {

        Reclamacion nuevo = usuarioService.registrarReclamo(id, asunto, descripcion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }


    @PostMapping("/{id}/devoluciones")
    public ResponseEntity<Devolucion> registrarDevolucion(@PathVariable Long id,@RequestParam String motivo,@RequestParam Long productoId) {
    Devolucion nueva = usuarioService.registrarDevolucion(id, motivo, productoId);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }
}
