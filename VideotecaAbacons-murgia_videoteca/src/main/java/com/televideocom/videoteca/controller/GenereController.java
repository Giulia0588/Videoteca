package com.televideocom.videoteca.controller;

import com.televideocom.videoteca.business.GenereBusiness;
import com.televideocom.videoteca.entities.Genere;
import com.televideocom.videoteca.errors.ExternalComunicationErrorException;
import com.televideocom.videoteca.errors.InternalServerErrorException;
import com.televideocom.videoteca.errors.NotFoundException;
import com.televideocom.videoteca.errors.NotValidException;
import lombok.Data;
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
@RequestMapping("/api/generi")
public class GenereController {

    @Autowired
    private GenereBusiness gb;

    @GetMapping(value = "/generi", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getGeneri() throws NotFoundException, ExternalComunicationErrorException {
        List<Genere> generi = gb.getGeneri();
        try {
            if (generi.isEmpty()) {
                throw new NotFoundException();
            }
            return new ResponseEntity<>(generi, HttpStatus.OK);
        } catch (Exception e) {
            throw new ExternalComunicationErrorException(e.getMessage());
        }
    }


    @GetMapping(value = "/genere/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getGenereById(@PathVariable Long id) throws NotFoundException, ExternalComunicationErrorException { //VERIFICARE QUESTO PATH VARIABLE
        Optional<Genere> genere = gb.getGenereById(id);
        try {
            if (genere.isEmpty()) {
                throw new NotFoundException();
            }
            return new ResponseEntity<>(genere, HttpStatus.OK);
        } catch (Exception e) {
            throw new ExternalComunicationErrorException(e.getMessage());
        }

    }


    @GetMapping(value = "/descrizione", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getGeneri(@RequestParam(name = "descrizione") String descrizione) throws BadRequestException, NotFoundException, ExternalComunicationErrorException {

        if (descrizione.length() < 3) {
            throw new BadRequestException("La descrizione deve essere di almeno 3 caratteri.");
        }
        List<Genere> generi = gb.getGeneriByDescrizione(descrizione);

        if (generi.isEmpty()) {
            throw new NotFoundException();
        }
        return new ResponseEntity<>(generi, HttpStatus.OK);

    }

    @PostMapping(value = "/inserisci", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Genere> inserisciGenere(@RequestBody Genere genere) throws InternalServerErrorException, NotValidException {
        try {
            List<Genere> generi = gb.getGeneriByDescrizione(genere.getDescrizione());
            if (generi.isEmpty()) {
                Genere inserisciGenere = gb.inserisciGenere(genere);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                throw new NotValidException();
            }
        } catch (Exception e) {
            throw new InternalServerErrorException();
        }
    }


}
