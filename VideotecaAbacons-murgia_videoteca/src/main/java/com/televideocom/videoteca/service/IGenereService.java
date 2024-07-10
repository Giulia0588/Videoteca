package com.televideocom.videoteca.service;

import com.televideocom.videoteca.entities.Genere;

import java.util.List;
import java.util.Optional;

public interface IGenereService {

    public List<Genere> getGeneri();
    public Optional<Genere> getGenereById(Long id);
    public List<Genere> getGeneriByDescrizione(String descrizione);


    public Genere inserisciGenere(Genere genere);

}
