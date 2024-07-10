package com.televideocom.videoteca.controller;


import com.televideocom.videoteca.business.FilmBusiness;
import com.televideocom.videoteca.entities.Film;
import com.televideocom.videoteca.errors.ExternalComunicationErrorException;
import com.televideocom.videoteca.errors.InternalServerErrorException;
import com.televideocom.videoteca.errors.NotFoundException;
import com.televideocom.videoteca.errors.NotValidException;
import com.televideocom.videoteca.pojos.PojoFilm;
import com.televideocom.videoteca.pojos.PojoFilmCompleto;
import com.televideocom.videoteca.pojos.PojoFilmGenere;
import com.televideocom.videoteca.pojos.PojoInterprete;
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
@RequestMapping("/api/films")
public class FilmController {


    @Autowired
    private FilmBusiness fb;

    @GetMapping(value = "/films", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getListaTitoliCompleta() throws NotFoundException, ExternalComunicationErrorException {
        List<Film> films = fb.getListaTitoliCompleta();
        try {
            if (films.isEmpty()) {
                throw new NotFoundException();
            }
            return new ResponseEntity<>(films, HttpStatus.OK);
        } catch (Exception e) {
            throw new ExternalComunicationErrorException(e.getMessage());
        }
    }


    @GetMapping(value = "/film/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTitoloCompletoById(@PathVariable Long id) throws NotFoundException, ExternalComunicationErrorException { //VERIFICARE QUESTO PATH VARIABLE
        Optional<Film> film = fb.getTitoloCompletoById(id);
        try {
            if (film.isEmpty()) {
                throw new NotFoundException();
            }
            return new ResponseEntity<>(film, HttpStatus.OK);
        } catch (Exception e) {
            throw new ExternalComunicationErrorException(e.getMessage());
        }
    }


    @GetMapping(value = "/titolo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getFilmsByTitolo(@RequestParam(name = "titolo") String titolo) throws BadRequestException, NotFoundException, ExternalComunicationErrorException {

        List<Film> films = fb.getFilmsByTitolo(titolo);
        if (films.isEmpty()) {
            throw new NotFoundException();
        }
        return new ResponseEntity<>(films, HttpStatus.OK);
    }

    @PostMapping(value = "/insert", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Film> inserisciFilm(@RequestBody PojoFilmCompleto film) throws InternalServerErrorException, NotValidException {
        try {
           Film savedFilm = fb.inserisciFilm(film);
           if(savedFilm == null){
               throw new NotValidException();
            } else {
               return new ResponseEntity<>(savedFilm, HttpStatus.OK);
            }
        } catch (Exception e) {
            throw new InternalServerErrorException();
        }
    }

    @GetMapping(value = "/filmTitAnn", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getListaTitoli() throws NotFoundException, ExternalComunicationErrorException {
        List<PojoFilm> films = fb.getListaTitoli();
        try {
            if (films.isEmpty()) {
                throw new NotFoundException();
            }
            return new ResponseEntity<>(films, HttpStatus.OK);
        } catch (Exception e) {
            throw new ExternalComunicationErrorException(e.getMessage());
        }
    }

    @GetMapping(value = "/filmTitId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTitoloById(@PathVariable Long id) throws NotFoundException, ExternalComunicationErrorException {
        PojoFilm film = fb.getTitoloById(id);

        try {
            if (film == null) {
                throw new NotFoundException("Film non trovato con ID: " + id);
            }
            return new ResponseEntity<>(film, HttpStatus.OK);
        } catch (Exception e) {
            throw new ExternalComunicationErrorException(e.getMessage());
        }
    }

    @GetMapping(value = "/filmByNome", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTitoloByNome(@RequestParam(name = "nome") String nome) throws NotFoundException, ExternalComunicationErrorException {
        List<PojoFilm> films = fb.getTitoloByNome(nome);
        try {
            if (films.isEmpty()) {
                throw new NotFoundException();
            }
            return new ResponseEntity<>(films, HttpStatus.OK);
        } catch (Exception e) {
            throw new ExternalComunicationErrorException(e.getMessage());
        }
    }


    @GetMapping(value = "/filmByAnno", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTitoloByAnno(@RequestParam(name = "anno") String anno) throws NotFoundException, ExternalComunicationErrorException {
        List<PojoFilm> films = fb.getTitoloByAnno(anno);
        try {
            if (films.isEmpty()) {
                throw new NotFoundException();
            }
            return new ResponseEntity<>(films, HttpStatus.OK);
        } catch (Exception e) {
            throw new ExternalComunicationErrorException(e.getMessage());
        }
    }

    @GetMapping(value = "/filmByGenere", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTitoloByGenere(@RequestParam(name = "genere") String genere) throws NotFoundException, ExternalComunicationErrorException {
        List<PojoFilmGenere> films = fb.getTitoloByGenere(genere);
        try {
            if (films.isEmpty()) {
                throw new NotFoundException();
            }
            return new ResponseEntity<>(films, HttpStatus.OK);
        } catch (Exception e) {
            throw new ExternalComunicationErrorException(e.getMessage());
        }
    }

    @GetMapping(value = "/filmByAttore", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTitoloByActor(@RequestParam(name = "nome") String nome, @RequestParam(name = "cognome") String cognome) throws NotFoundException, ExternalComunicationErrorException {
        List<PojoInterprete> films = fb.getTitoloByActor(nome, cognome);
        try {
            //minore di 3
            if (films.isEmpty()) {
                throw new NotFoundException();
            }
            return new ResponseEntity<>(films, HttpStatus.OK);
        } catch (Exception e) {
            throw new ExternalComunicationErrorException(e.getMessage());
        }
    }

    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateFilm(@RequestBody PojoFilm film) throws InternalServerErrorException, NotValidException {
        try {
            Film updatedFilm = fb.updateFilm(film);
            if(updatedFilm == null){
                throw new NotValidException();
            } else {
                return new ResponseEntity<>(updatedFilm, HttpStatus.OK);
            }
        } catch (Exception e) {
            throw new InternalServerErrorException();
        }
    }

    @PostMapping(value = "/update-genere", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateFilmGenere(@RequestParam(name = "idFilm") Long idFilm, @RequestParam (name = "genereId") Long genereId) throws InternalServerErrorException, NotValidException {
        try {
            Film updatedFilmGenere = fb.updateFilmGenere(idFilm, genereId);
            if(updatedFilmGenere == null){
                throw new NotValidException();
            } else {
                return new ResponseEntity<>(updatedFilmGenere, HttpStatus.OK);
            }
        } catch (Exception e) {
            throw new InternalServerErrorException();
        }
    }

    @PostMapping(value = "/deleteFilm", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteFilm(@RequestParam(name = "idFilm") Long idFilm) {
        try {
            PojoFilmCompleto deletedFilm = fb.deleteFilm(idFilm);
            if (deletedFilm != null) {
                return new ResponseEntity<>(deletedFilm, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Film not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/addAttore", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> aggiungiAttoreFilm(@RequestParam(name = "idFilm") Long idFilm, @RequestParam (name = "idInterprete") Long idInterprete) throws InternalServerErrorException, NotValidException {
        try {
            Film attoreIns = fb.aggiungiAttoreFilm(idFilm, idInterprete);
            if(attoreIns == null){
                throw new NotValidException();
            } else {
                return new ResponseEntity<>(attoreIns, HttpStatus.OK);
            }
        } catch (Exception e) {
            throw new InternalServerErrorException();
        }
    }

    @PostMapping(value = "/delAttore", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> rimuoviAttoreFilm(@RequestParam(name = "idFilm") Long idFilm, @RequestParam (name = "idInterprete") Long idInterprete) throws InternalServerErrorException, NotValidException {
        try {
            Film attoreElim = fb.rimuoviAttoreFilm(idFilm, idInterprete);
            if(attoreElim == null){
                throw new NotValidException();
            } else {
                return new ResponseEntity<>(attoreElim, HttpStatus.OK);
            }
        } catch (Exception e) {
            throw new InternalServerErrorException();
        }
    }



    //-------------------------------------------------------


    @GetMapping(value = "/ricercaGenerica", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getFilmsByInterpreteTitoloGenere(@RequestParam(name = "ricerca") String ricerca) throws NotFoundException, ExternalComunicationErrorException {
        List<Film> films = fb.getFilmsByInterpreteTitoloGenere(ricerca);
        try{
            if (films.isEmpty()) {
                throw new NotFoundException();
            } else {
                return new ResponseEntity<>(films, HttpStatus.OK);
            }
        } catch (Exception e) {
            throw new ExternalComunicationErrorException(e.getMessage());
        }
    }
}
