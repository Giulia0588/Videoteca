package com.televideocom.videoteca.service.implementazione;

import com.televideocom.videoteca.entities.Film;
import com.televideocom.videoteca.entities.Genere;
import com.televideocom.videoteca.entities.Interprete;
import com.televideocom.videoteca.pojos.PojoFilm;
import com.televideocom.videoteca.pojos.PojoFilmCompleto;
import com.televideocom.videoteca.pojos.PojoFilmGenere;
import com.televideocom.videoteca.pojos.PojoInterprete;
import com.televideocom.videoteca.repository.FilmRepo;
import com.televideocom.videoteca.service.IFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class FilmService implements IFilmService {

    @Autowired
    private FilmRepo fp;

    @Autowired
    private InterpreteService is;

    @Autowired
    private GenereService gs;

   

    //I METODI UGUALI PER TUTTE LE ENTITY

    public List<Film> getListaTitoliCompleta() {
        List<Film> films = fp.findAll();
        return films;
    }

    @Override
    public Optional<Film> getTitoloCompletoById(Long id) {
        Optional<Film> film = fp.findById(id);
        return film;
    }

    @Override
    public List<Film> getFilmsByTitolo(String titolo) {
        List<Film> films = fp.findByTitoloContainingIgnoreCase(titolo);
        return films;
    }

    @Override
    public Film inserisciFilm(PojoFilmCompleto film) {
        Film nuovoFilm = new Film();
        nuovoFilm.setIdFilm(film.getId_film());
        nuovoFilm.setTitolo(film.getTitolo());
        nuovoFilm.setAnno(film.getAnno());
        Genere genere = gs.getGenereById(film.getId_genere()).get();
        nuovoFilm.setGenere(genere);
        List<Interprete> interpreti = new ArrayList<Interprete>();
        for (Long id_interpreti : film.getId_interpreti()) {
            Interprete interprete = is.getInterpreteById(id_interpreti).get();
            interpreti.add(interprete);
        }
        nuovoFilm.setInterpreti(interpreti);
        Film salvaFilm = fp.save(nuovoFilm);
        return salvaFilm;
    }


    //------------------------------------------------------------------------
    @Override
    public List<PojoFilm> getListaTitoli() {
        List<Film> filmList = fp.findAll();
        List<PojoFilm> pojoFilmList = new ArrayList<PojoFilm>();
        for (Film f : filmList) {
            PojoFilm pf = new PojoFilm();
            pf.setId_film(f.getIdFilm());
            pf.setTitolo(f.getTitolo());
            pf.setAnno(f.getAnno());
            pojoFilmList.add(pf);
        }
        return pojoFilmList;
    }

    @Override
    public PojoFilm getTitoloById(Long id) {
        Optional<Film> film = fp.findById(id);

        PojoFilm pf = new PojoFilm();
        pf.setId_film(film.get().getIdFilm());
        pf.setTitolo(film.get().getTitolo());
        pf.setAnno(film.get().getAnno());
        return pf;
    }

    @Override
    public List<PojoFilm> getTitoloByNome(String nome) {
        List<Film> filmList = fp.findByTitoloContainingIgnoreCase(nome);
        List<PojoFilm> pojoFilmList = new ArrayList<>();
        for (Film film : filmList) {
            PojoFilm pojoFilm = new PojoFilm();
            pojoFilm.setId_film(film.getIdFilm());
            pojoFilm.setTitolo(film.getTitolo());
            pojoFilm.setAnno(film.getAnno());
            pojoFilmList.add(pojoFilm);
        }
        return pojoFilmList;
    }

    @Override
    public List<PojoFilm> getTitoloByAnno(String anno) {
        List<Film> filmLista = fp.findByAnnoContainingIgnoreCase(anno);
        List<PojoFilm> pojoFilmList = new ArrayList<>();
        for (Film film : filmLista) {
            PojoFilm pojoFilm = new PojoFilm();
            pojoFilm.setId_film(film.getIdFilm());
            pojoFilm.setTitolo(film.getTitolo());
            pojoFilm.setAnno(film.getAnno());
            pojoFilmList.add(pojoFilm);
        }
        return pojoFilmList;
    }

    @Override
    public List<PojoFilmGenere> getTitoloByGenere(String descrizGenere) {
        List<Film> films = fp.findByGenereDescrizioneIgnoreCase(descrizGenere);
        List<PojoFilmGenere> pojoFilm = new ArrayList<PojoFilmGenere>();

        for (Film film : films) {
            PojoFilmGenere pFilm = new PojoFilmGenere();
            pFilm.setTitolo(film.getTitolo());
            pFilm.setAnno(film.getAnno());
            pFilm.setGenere(film.getGenere());
            pojoFilm.add(pFilm);
        }
        return pojoFilm;
    }

    @Override
    public List<PojoInterprete> getTitoloByActor(String nome, String cognome) {
        Optional<Interprete> interprete = is.getInterpreteByNomeCognome(nome, cognome);
        List<PojoInterprete> films = new ArrayList<PojoInterprete>();

        if (interprete.isPresent()) {
            List<Film> filmInterprete = fp.findByInterpreti(interprete.get());
            for (Film film : filmInterprete) {
                PojoInterprete pojoFilm = new PojoInterprete();
                pojoFilm.setTitolo(film.getTitolo());
                pojoFilm.setAnno(film.getAnno());
                pojoFilm.setInterp(film.getInterpreti());
                films.add(pojoFilm);
            }
        }
        return films;
    }

    @Override
    public Film updateFilm(PojoFilm film) {
        Film filmToUpdate = fp.findById(film.getId_film()).get();
        // Verifica se il titolo nel film da aggiornare non è nullo e aggiorna solo se è diverso da null
        if (film.getTitolo() != null) {
            filmToUpdate.setTitolo(film.getTitolo());
        }
        // Verifica se l'anno nel film da aggiornare non è nullo e aggiorna solo se è diverso da null
        if (film.getAnno() != null) {
            filmToUpdate.setAnno(film.getAnno());
        }
        Film savedFilm = fp.save(filmToUpdate);
        return savedFilm;
    }

    @Override
    public Film updateFilmGenere(Long idFilm, Long genereId) {
        // Ottieni il film dato l'ID
        Film updFilm = fp.findById(idFilm).get();
        if (updFilm == null) {
            // Gestisci il caso in cui il film non sia stato trovato
            return null;
        }
        // Ottieni il genere dato l'ID
        Genere genere = gs.getGenereById(genereId).get();
        if (genere == null) {
            // Gestisci il caso in cui il genere non sia stato trovato
            return null;
        }
        // Aggiorna genere del film e salva
        updFilm.setGenere(genere);
        return fp.save(updFilm);
    }

    @Override
    public PojoFilmCompleto deleteFilm(Long idFilm) {
        Optional<Film> optionalFilm = fp.findById(idFilm);
        Film filmToDelete = optionalFilm.orElse(null);
        if (filmToDelete != null) {
            Long idGenere = filmToDelete.getGenere() != null ? filmToDelete.getGenere().getIdGenere() : null;
            List<Long> idInterpreti = new ArrayList<>();
            for (Interprete interprete : filmToDelete.getInterpreti()) {
                idInterpreti.add(interprete.getIdInterprete());
            }
            fp.delete(filmToDelete);
            return new PojoFilmCompleto(idFilm, filmToDelete.getTitolo(), filmToDelete.getAnno(), idGenere, idInterpreti);
        } else {
            return null;
        }
    }

    @Override
    public Film aggiungiAttoreFilm(Long idFilm, Long idInterprete) {
        Film film = fp.findById(idFilm).get();
        Interprete interprete = is.getInterpreteById(idInterprete).get();
        List<Interprete> interpreti = film.getInterpreti();
        boolean isPresent = false;
        for (Interprete interp : interpreti) {
            if (interp.equals(interprete)) {
                isPresent = true;

            }
        }
        if (!isPresent) {
            interpreti.add(interprete);
            film.setInterpreti(interpreti);
        }
        return fp.save(film);
    }

    @Override
    public Film rimuoviAttoreFilm(Long idFilm, Long idInterprete) {
        Film film = fp.findById(idFilm).get();
        Interprete interprete = is.getInterpreteById(idInterprete).get();
        List<Interprete> interpreti = film.getInterpreti();
        boolean isPresent = false;
        for (Interprete interp : interpreti) {
            if (interp.equals(interprete)) {
                isPresent = true;

            }
        }
        if (isPresent) {
            interpreti.remove(interprete);
            film.setInterpreti(interpreti);
        }
        return fp.save(film);
    }



    //----------------------------------


    @Override
    public List<Film> getFilmsByInterpreteTitoloGenere(String ricerca) {
        List<Film> films = fp.findByTitoloOrGenereDescrizioneOrInterpreteContaining(ricerca);
        return films;
   }

}



