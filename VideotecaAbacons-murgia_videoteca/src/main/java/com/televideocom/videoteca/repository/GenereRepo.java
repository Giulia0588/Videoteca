package com.televideocom.videoteca.repository;

import com.televideocom.videoteca.entities.Genere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface GenereRepo extends JpaRepository<Genere, Long> {

    List<Genere> findByDescrizioneContainingIgnoreCase(String descrizione);
}
