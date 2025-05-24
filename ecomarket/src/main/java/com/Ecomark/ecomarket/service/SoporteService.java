package com.Ecomark.ecomarket.service;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecomark.ecomarket.model.SolicitudSoporte;
import com.Ecomark.ecomarket.model.Usuario;
import com.Ecomark.ecomarket.repository.SolicitudSoporteRepository;
import com.Ecomark.ecomarket.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SoporteService {
    @Autowired
    private SolicitudSoporteRepository solicitudSoporteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

 public SolicitudSoporte enviarSoporte(Long clienteId, String asunto, String mensaje) {
        Usuario cliente = usuarioRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        SolicitudSoporte s = new SolicitudSoporte();
        s.setAsunto(asunto);
        s.setMensaje(mensaje);
        s.setFechaSolicSoporte(new Date());
        s.setCliente(cliente);
        s.setEstado("Enviado");

        return solicitudSoporteRepository.save(s);
    }
}