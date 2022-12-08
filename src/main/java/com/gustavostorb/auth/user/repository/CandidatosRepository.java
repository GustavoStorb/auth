package com.gustavostorb.auth.user.repository;

import com.gustavostorb.auth.user.model.Candidatos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CandidatosRepository extends JpaRepository<Candidatos, Long> {

    @Query(value = "SELECT c.genero, count(c.genero) FROM candidatos c GROUP BY c.genero")
    Optional<List<String>> findByGenero();

    @Query(value = "SELECT c.estado, count(c.estado) FROM candidatos c GROUP BY c.estado")
    Optional<List<String>> findByEstado();
}
