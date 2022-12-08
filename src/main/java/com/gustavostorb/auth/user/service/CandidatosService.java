package com.gustavostorb.auth.user.service;

import com.gustavostorb.auth.user.dto.EstadoDTO;
import com.gustavostorb.auth.user.dto.GeneroDTO;
import com.gustavostorb.auth.user.model.Candidatos;
import com.gustavostorb.auth.user.model.User;
import com.gustavostorb.auth.user.repository.CandidatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CandidatosService {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private CandidatosRepository candidatosRepository;


    public List<GeneroDTO> findByGenero(String token) {
        User authorizedUser = this.tokenService.getUserByTokenAndValidate(token);
        if (authorizedUser == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuário não autorizado");
        }
        if (this.candidatosRepository.findByGenero().isPresent()) {

            List<String> listaGeneros = this.candidatosRepository.findByGenero().get();
            List<GeneroDTO> listaGenerosDTO = new ArrayList<GeneroDTO>();
            for (String genero : listaGeneros) {
                GeneroDTO generoDTO = new GeneroDTO();
                String[] generoArray = genero.split(",");
                generoDTO.setGenero(generoArray[0]);
                generoDTO.setQuantidade(Integer.parseInt(generoArray[1]));
                listaGenerosDTO.add(generoDTO);
            }
            return listaGenerosDTO;
        } else {
            return new ArrayList<GeneroDTO>();
        }
    }

    public List<EstadoDTO> findByEstado(String token) {
        User authorizedUser = this.tokenService.getUserByTokenAndValidate(token);
        if(authorizedUser == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuário não autorizado");
        }
        if(this.candidatosRepository.findByEstado().isPresent()){

            List<String> listaEstados = this.candidatosRepository.findByEstado().get();
            List<EstadoDTO> listaEstadosDTO = new ArrayList<EstadoDTO>();
            for (String estado : listaEstados) {
                EstadoDTO estadoDTO = new EstadoDTO();
                String[] estadoArray = estado.split(",");
                estadoDTO.setEstado(estadoArray[0]);
                estadoDTO.setQuantidade(Integer.parseInt(estadoArray[1]));
                listaEstadosDTO.add(estadoDTO);
            }
            return listaEstadosDTO;
        } else {
            return new ArrayList<EstadoDTO>();
        }

    }
}
