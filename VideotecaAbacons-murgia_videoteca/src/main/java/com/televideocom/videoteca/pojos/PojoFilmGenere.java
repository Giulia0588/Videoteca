package com.televideocom.videoteca.pojos;

import com.televideocom.videoteca.entities.Genere;

import java.util.Objects;

public class PojoFilmGenere {

    private String titolo;
    private String anno;
    private Genere genere;


    public PojoFilmGenere() {
    }

    public PojoFilmGenere(String titolo, String anno, Genere genere) {
        this.titolo = titolo;
        this.anno = anno;
        this.genere = genere;
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

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "PojoFilmGenere{" +
                "titolo='" + titolo + '\'' +
                ", anno='" + anno + '\'' +
                ", genere=" + genere +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PojoFilmGenere that = (PojoFilmGenere) o;
        return Objects.equals(titolo, that.titolo) && Objects.equals(anno, that.anno) && Objects.equals(genere, that.genere);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titolo, anno, genere);
    }
}
