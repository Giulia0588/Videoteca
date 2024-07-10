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
@Table(name = "interprete")
public class Interprete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_interprete")
    private Long idInterprete;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cognome")
    private String cognome;

    @JsonBackReference
    @ManyToMany(mappedBy = "interpreti")
    private List<Film> films;
}


