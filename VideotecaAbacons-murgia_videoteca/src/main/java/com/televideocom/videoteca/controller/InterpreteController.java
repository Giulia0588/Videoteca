package com.televideocom.videoteca.controller;


import com.televideocom.videoteca.business.InterpreteBusiness;
import com.televideocom.videoteca.entities.Interprete;
import com.televideocom.videoteca.errors.ExternalComunicationErrorException;
import com.televideocom.videoteca.errors.InternalServerErrorException;
import com.televideocom.videoteca.errors.NotFoundException;
import com.televideocom.videoteca.errors.NotValidException;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/interpreti")
public class InterpreteController {

    @Autowired
    private InterpreteBusiness ib;

    @GetMapping(value = "/interpreti", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getInterpreti() throws NotFoundException, ExternalComunicationErrorException {
        List<Interprete> interpreti = ib.getInterpreti();
        try {
            if (interpreti.isEmpty()) {
                throw new NotFoundException();
            }
            return new ResponseEntity<>(interpreti, HttpStatus.OK);
        } catch (Exception e) {
            throw new ExternalComunicationErrorException(e.getMessage());
        }
    }


    @GetMapping(value = "/interprete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getInterpreteById(@PathVariable Long id) throws NotFoundException, ExternalComunicationErrorException { //VERIFICARE QUESTO PATH VARIABLE
        Optional<Interprete> interprete = ib.getInterpreteById(id);
        try {
            if (interprete.isEmpty()) {
                throw new NotFoundException();
            }
            return new ResponseEntity<>(interprete, HttpStatus.OK);
        } catch (Exception e) {
            throw new ExternalComunicationErrorException(e.getMessage());
        }
    }


    @GetMapping(value = "/nome", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getNomi(@RequestParam(name = "nome") String nome) throws BadRequestException, NotFoundException, ExternalComunicationErrorException {

        if (nome.length() < 3) {
            throw new BadRequestException("Il nome deve essere di almeno 3 caratteri.");
        }
        List<Interprete> interpreti = ib.getInterpretiByNome(nome);

        if (interpreti.isEmpty()) {
            throw new NotFoundException();
        }
        return new ResponseEntity<>(interpreti, HttpStatus.OK);
    }

    @GetMapping(value = "/cognome", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCognomi(@RequestParam(name = "cognome") String cognome) throws BadRequestException, NotFoundException, ExternalComunicationErrorException {

        if (cognome.length() < 3) {
            throw new BadRequestException("Il cognome deve essere di almeno 3 caratteri.");
        }
        List<Interprete> interpreti = ib.getInterpretiByCognome(cognome);

        if (interpreti.isEmpty()) {
            throw new NotFoundException();
        }
        return new ResponseEntity<>(interpreti, HttpStatus.OK);
    }

    @GetMapping(value = "/nomeAndCognome", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getNomiCognomi(@RequestParam(name = "nome") String nome, @RequestParam(name = "cognome") String cognome) throws BadRequestException, NotFoundException, ExternalComunicationErrorException {

        if (nome.length() <3 || cognome.length() < 3) {
            throw new BadRequestException("Il cognome deve essere di almeno 3 caratteri.");
        }
        List<Interprete> interpreti = ib.getInterpretiByNomeAndCognome(nome, cognome);

        if (interpreti.isEmpty()) {
            throw new NotFoundException();
        }
        return new ResponseEntity<>(interpreti, HttpStatus.OK);
    }

    @GetMapping(value = "/nomeCognome", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getNomeCognome(@RequestParam(name = "nome") String nome, @RequestParam(name = "cognome") String cognome) throws BadRequestException, NotFoundException, ExternalComunicationErrorException {

        if (nome.length() <3 || cognome.length() < 3) {
            throw new BadRequestException("Il cognome deve essere di almeno 3 caratteri.");
        }
        Optional<Interprete> interprete = ib.getInterpreteByNomeCognome(nome, cognome);

        if (interprete.isEmpty()) {
            throw new NotFoundException();
        }
        return new ResponseEntity<>(interprete, HttpStatus.OK);
    }

    @PostMapping(value = "/inserisci", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Interprete> inserisciInterprete(@RequestBody Interprete interprete) throws InternalServerErrorException, NotValidException {
        try {
            List<Interprete> interpreti = ib.getInterpretiByNome(interprete.getNome());
            if (interpreti.isEmpty()) {
                Interprete inserisciInterpreti = ib.inserisciInterprete(interprete);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                throw new NotValidException();
            }
        } catch (Exception e) {
            throw new InternalServerErrorException();
        }
    }
}
