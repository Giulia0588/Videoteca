package com.televideocom.videoteca.service;

import com.televideocom.videoteca.entities.Interprete;
import com.televideocom.videoteca.errors.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface IInterpreteService {

    public List<Interprete> getInterpreti();
    public Optional<Interprete> getInterpreteById(Long id);
    public List<Interprete> getInterpretiByNome(String nome);
    public List<Interprete> getInterpretiByCognome(String cognome);
    public List<Interprete> getInterpretiByNomeAndCognome(String nome, String cognome);
    public Optional<Interprete> getInterpreteByNomeCognome(String nome, String cognome);
    public Interprete inserisciInterprete(Interprete interprete);
    public void eliminaInterprete(Long id) throws NotFoundException;



}
