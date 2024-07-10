package com.televideocom.videoteca.service.implementazione;

import com.televideocom.videoteca.entities.Genere;
import com.televideocom.videoteca.errors.NotFoundException;
import com.televideocom.videoteca.repository.GenereRepo;
import com.televideocom.videoteca.service.IGenereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class GenereService implements IGenereService {

    @Autowired
    private GenereRepo gr;

    public List<Genere> getGeneri() {
        List<Genere> generi = gr.findAll();
        return generi;
    }

    @Override
    public Optional<Genere> getGenereById(Long id) {
        Optional<Genere> genere = gr.findById(id);
        return genere;

    }

    @Override
    public List<Genere> getGeneriByDescrizione(String descrizione) {

        List<Genere> generi = gr.findByDescrizioneContainingIgnoreCase(descrizione);
        return generi;
    }

    public Genere inserisciGenere(Genere genere) {
        Genere nuovoGenere = gr.save(genere);
        return nuovoGenere;
    }
}

