package com.gustavostorb.auth.user.controller;

import com.gustavostorb.auth.user.dto.EstadoDTO;
import com.gustavostorb.auth.user.dto.GeneroDTO;
import com.gustavostorb.auth.user.model.Candidatos;
import com.gustavostorb.auth.user.service.CandidatosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/candidatos")
public class DataController {

    @Autowired
    public CandidatosService candidatosService;

    @GetMapping(value = "/estado", produces = "application/json")
    public ResponseEntity<List<EstadoDTO>> findByEstado(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(this.candidatosService.findByEstado(token));
    }

    @GetMapping(value = "/genero", produces = "application/json")
    public ResponseEntity<List<GeneroDTO>> findByGenero(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(this.candidatosService.findByGenero(token));
    }
}
