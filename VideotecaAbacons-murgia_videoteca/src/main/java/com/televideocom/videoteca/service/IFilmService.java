package com.televideocom.videoteca.service;

import com.televideocom.videoteca.entities.Film;
import com.televideocom.videoteca.pojos.PojoFilm;
import com.televideocom.videoteca.pojos.PojoFilmCompleto;
import com.televideocom.videoteca.pojos.PojoFilmGenere;
import com.televideocom.videoteca.pojos.PojoInterprete;

import java.util.List;
import java.util.Optional;



public interface IFilmService {
    //classici metodi uguali per tutti
    public List<Film> getListaTitoliCompleta();

    public Optional<Film> getTitoloCompletoById(Long id);

    public List<Film> getFilmsByTitolo(String titolo);

    public Film inserisciFilm(PojoFilmCompleto film);
    //public void eliminaFilm(Long id);
    //metodi particolari

    public List<PojoFilm> getListaTitoli();

    public PojoFilm getTitoloById(Long id);

    public List<PojoFilm> getTitoloByNome(String titolo);

    public List<PojoFilm> getTitoloByAnno(String anno);

    public List<PojoFilmGenere> getTitoloByGenere(String genere);

    public List<PojoInterprete> getTitoloByActor(String nome, String cognome);

    public Film updateFilm(PojoFilm film);

    public Film updateFilmGenere(Long idFilm, Long genereId);

    public PojoFilmCompleto deleteFilm(Long idFilm);

    public Film aggiungiAttoreFilm(Long idFilm, Long idInterprete);

    public Film rimuoviAttoreFilm(Long idFilm, Long idInterprete);


    //----------------------------------


   public List<Film> getFilmsByInterpreteTitoloGenere(String ricerca);
}
