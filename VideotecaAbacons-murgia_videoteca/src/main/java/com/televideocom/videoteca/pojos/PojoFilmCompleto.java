package com.televideocom.videoteca.pojos;


import java.util.List;

public class PojoFilmCompleto {

    private Long id_film;
    private String titolo;
    private String anno;
    private Long id_genere;
    private List<Long> id_interpreti;

    public PojoFilmCompleto() {
    }

    public PojoFilmCompleto(Long id_film, String titolo, String anno, Long id_genere, List<Long> id_interpreti) {
        this.id_film = id_film;
        this.titolo = titolo;
        this.anno = anno;
        this.id_genere = id_genere;
        this.id_interpreti = id_interpreti;
    }

    public Long getId_film() {
        return id_film;
    }

    public void setId_film(Long id_film) {
        this.id_film = id_film;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAnno() {
        return anno;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    public Long getId_genere() {
        return id_genere;
    }

    public void setId_genere(Long id_genere) {
        this.id_genere = id_genere;
    }

    public List<Long> getId_interpreti() {
        return id_interpreti;
    }

    public void setId_interpreti(List<Long> id_interpreti) {
        this.id_interpreti = id_interpreti;
    }
}


