package com.televideocom.videoteca.repository;


import com.televideocom.videoteca.entities.Interprete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InterpreteRepo extends JpaRepository <Interprete, Long>{

        List<Interprete> findByNomeContainingIgnoreCase(String nome);
        List<Interprete> findByCognomeContainingIgnoreCase(String cognome);
        List<Interprete> findByNomeContainingIgnoreCaseAndCognomeContainingIgnoreCase(String nome, String cognome);
        Optional<Interprete> findByNomeAndCognomeEqualsIgnoreCase(String nome, String cognome);
}
