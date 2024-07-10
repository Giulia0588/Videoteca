package com.televideocom.videoteca.business;

import com.televideocom.videoteca.entities.Genere;
import com.televideocom.videoteca.service.IGenereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class GenereBusiness {

    @Autowired
    private IGenereService igs;

    public List<Genere> getGeneri(){
        return igs.getGeneri();
    }

    public Optional<Genere> getGenereById(Long id){
        return igs.getGenereById(id);
    }


    public List <Genere> getGeneriByDescrizione(String descrizione) {
        return igs.getGeneriByDescrizione(descrizione);
    }


    public Genere inserisciGenere(Genere genere) {
        return igs.inserisciGenere(genere);
    }
}
