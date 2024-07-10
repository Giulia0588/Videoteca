package com.televideocom.videoteca.business;

import com.televideocom.videoteca.entities.Interprete;
import com.televideocom.videoteca.service.IInterpreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class InterpreteBusiness {

    @Autowired
    private IInterpreteService iis;

    public List<Interprete> getInterpreti(){
        return iis.getInterpreti();
    }

    public Optional<Interprete> getInterpreteById(Long id){
        return iis.getInterpreteById(id);
    }

    public List <Interprete> getInterpretiByNome(String nome) {
        return iis.getInterpretiByNome(nome);
    }
    public List<Interprete> getInterpretiByCognome(String cognome) {
        return iis.getInterpretiByCognome(cognome);
    }

    public List<Interprete> getInterpretiByNomeAndCognome(String nome, String cognome) {
        return iis.getInterpretiByNomeAndCognome(nome, cognome);
    }

    public Optional<Interprete> getInterpreteByNomeCognome(String nome, String cognome) {
        return iis.getInterpreteByNomeCognome(nome, cognome);
    }

    public Interprete inserisciInterprete(Interprete interprete) {
        return iis.inserisciInterprete(interprete);
    }
}
