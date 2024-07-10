package com.televideocom.videoteca.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_film")
    private Long idFilm;

    @Column(name = "titolo")
    private String titolo;

    @Column(name = "anno")
    private String anno;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "id_genere")
    private Genere genere; //andrà nel mappedby di genere

    @JsonManagedReference
    @ManyToMany
    @JoinTable(
            name = "film_interprete",
            joinColumns = @JoinColumn(name = "id_film"),
            inverseJoinColumns =  @JoinColumn(name =     "id_interprete")
    )
    private List<Interprete>interpreti;




}
