package com.televideocom.videoteca.pojos;


public class PojoFilm {

    private Long id_film;
    private String titolo;
    private String anno;


    public PojoFilm() {
    }

    public PojoFilm(Long id_film, String titolo, String anno) {
        this.id_film = id_film;
        this.titolo = titolo;
        this.anno = anno;
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
}