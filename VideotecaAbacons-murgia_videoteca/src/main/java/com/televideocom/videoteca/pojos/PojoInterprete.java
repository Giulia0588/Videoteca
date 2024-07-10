package com.televideocom.videoteca.pojos;

import com.televideocom.videoteca.entities.Interprete;
import java.util.List;



public class PojoInterprete {

    private String titolo;
    private String anno;
    private List<Interprete> interp;


    public PojoInterprete() {
    }

    public PojoInterprete(String titolo, String anno, List<Interprete> interp) {
        this.titolo = titolo;
        this.anno = anno;
        this.interp = interp;
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

    public List<Interprete> getInterp() {
        return interp;
    }

    public void setInterp(List<Interprete> interp) {
        this.interp = interp;
    }
}
