package com.televideocom.videoteca.service.implementazione;

import com.televideocom.videoteca.entities.Interprete;
import com.televideocom.videoteca.errors.NotFoundException;
import com.televideocom.videoteca.repository.InterpreteRepo;
import com.televideocom.videoteca.service.IInterpreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InterpreteService implements IInterpreteService {
    @Autowired
    private InterpreteRepo ir;

    public List<Interprete> getInterpreti() {
        List<Interprete> interpreti = ir.findAll();
        return interpreti;
    }

    @Override
    public Optional<Interprete> getInterpreteById(Long id) {
        Optional<Interprete> interprete = ir.findById(id);
        return interprete;

    }

    @Override
    public List<Interprete> getInterpretiByNome(String nome) {

        List<Interprete> interpreti = ir.findByNomeContainingIgnoreCase(nome);
        return interpreti;
    }

    @Override
    public List<Interprete> getInterpretiByCognome(String cognome) {

        List<Interprete> interpreti = ir.findByCognomeContainingIgnoreCase(cognome);
        return interpreti;
    }

    @Override
    public List<Interprete> getInterpretiByNomeAndCognome(String nome, String cognome) {

        List<Interprete> interpreti = ir.findByNomeContainingIgnoreCaseAndCognomeContainingIgnoreCase(nome, cognome);
        return interpreti;
    }

    @Override
    public Optional<Interprete> getInterpreteByNomeCognome(String nome, String cognome) {
        Optional<Interprete> interprete = ir.findByNomeAndCognomeEqualsIgnoreCase(nome, cognome);
        return interprete;
    }


    @Override
    public Interprete inserisciInterprete(Interprete interprete) {
        Interprete nuovoInterprete = ir.save(interprete);
        return nuovoInterprete;
    }

    @Override
    public void eliminaInterprete(Long id) throws NotFoundException {
        if (!ir.existsById(id)) {
            throw new NotFoundException("L'interprete non esiste nel database.");
        }
        ir.deleteById(id);
    }



}
