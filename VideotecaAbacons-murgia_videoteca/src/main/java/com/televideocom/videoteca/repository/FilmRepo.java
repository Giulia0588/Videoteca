package com.televideocom.videoteca.repository;

import com.televideocom.videoteca.entities.Film;
import com.televideocom.videoteca.entities.Interprete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FilmRepo extends JpaRepository<Film, Long> {

    List<Film> findByTitoloContainingIgnoreCase(String titolo);
    List<Film> findByAnnoContainingIgnoreCase(String anno);
    List<Film> findByGenereDescrizioneIgnoreCase(String descrizGenere);
    List<Film> findByInterpreti(Interprete interprete);

    //----------------
    @Query("SELECT DISTINCT f FROM Film f " +
            "LEFT JOIN f.genere g " +
            "LEFT JOIN f.interpreti i " +
            "WHERE LOWER(f.titolo) LIKE LOWER(CONCAT('%', :ricerca, '%')) " +
            "OR LOWER(g.descrizione) LIKE LOWER(CONCAT('%', :ricerca, '%')) " +
            "OR LOWER(i.nome) LIKE LOWER(CONCAT('%', :ricerca, '%')) " +
            "OR LOWER(i.cognome) LIKE LOWER(CONCAT('%', :ricerca, '%'))")
    List<Film> findByTitoloOrGenereDescrizioneOrInterpreteContaining(String ricerca);
}

