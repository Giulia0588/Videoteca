package com.televideocom.videoteca.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "genere")
public class Genere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_genere")
    private Long idGenere;
    @Column(name = "descrizione")
    private String descrizione;

    @JsonBackReference
    @OneToMany(mappedBy = "genere")
    private List<Film> films;
}
