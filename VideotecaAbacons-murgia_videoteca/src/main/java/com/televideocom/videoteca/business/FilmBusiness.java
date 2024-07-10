package com.televideocom.videoteca.business;

import com.televideocom.videoteca.entities.Film;
import com.televideocom.videoteca.pojos.PojoFilm;
import com.televideocom.videoteca.pojos.PojoFilmCompleto;
import com.televideocom.videoteca.pojos.PojoFilmGenere;
import com.televideocom.videoteca.pojos.PojoInterprete;
import com.televideocom.videoteca.service.IFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FilmBusiness {

    @Autowired
    private IFilmService ifs;

    public List<Film> getListaTitoliCompleta() {
        return ifs.getListaTitoliCompleta();
    }

    public List<PojoFilm> getListaTitoli() {
        return ifs.getListaTitoli();
    }

    public Optional<Film> getTitoloCompletoById(Long id) {
        return ifs.getTitoloCompletoById(id);
    }

    public List<Film> getFilmsByTitolo(String titolo) {
        return ifs.getFilmsByTitolo(titolo);
    }

    public Film inserisciFilm(PojoFilmCompleto film) {
        return ifs.inserisciFilm(film);
    }

    public PojoFilm getTitoloById(Long id) {
        return ifs.getTitoloById(id);
    }

    public List<PojoFilm> getTitoloByNome(String nome) {
        return ifs.getTitoloByNome(nome);
    }

    public List<PojoFilm> getTitoloByAnno(String anno) {
        return ifs.getTitoloByAnno(anno);
    }

    public List<PojoFilmGenere> getTitoloByGenere(String genere) {
        return ifs.getTitoloByGenere(genere);
    }

    public List<PojoInterprete> getTitoloByActor(String nome, String cognome) {
        return ifs.getTitoloByActor(nome, cognome);
    }

    public Film updateFilm(PojoFilm film) {
        return ifs.updateFilm(film);
    }

    public Film updateFilmGenere(Long idFilm, Long genereId) {
        return ifs.updateFilmGenere(idFilm, genereId);
    }

    public PojoFilmCompleto deleteFilm(Long idFilm) {
        return ifs.deleteFilm(idFilm);
    }

    public Film aggiungiAttoreFilm(Long idFilm, Long idInterprete) {
        return ifs.aggiungiAttoreFilm(idFilm, idInterprete);
    }

    public Film rimuoviAttoreFilm(Long idFilm, Long idInterprete) {
        return ifs.rimuoviAttoreFilm(idFilm, idInterprete);
    }


    //----------------------------------------

   public List<Film> getFilmsByInterpreteTitoloGenere(String ricerca) {
        return ifs.getFilmsByInterpreteTitoloGenere(ricerca);
    }
}


