package com.meusite.screensoundmusic.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artistas")
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;
    @Enumerated(EnumType.STRING)
    private CategoriaArtista categoriaArtista;
    @OneToMany(mappedBy = "artista", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<Musica> listaDeMusicas = new ArrayList<>();

    @Deprecated
    public Artista() {
    }

    public Artista(String nome, CategoriaArtista categoriaArtista) {
        this.nome = nome;
        this.categoriaArtista = categoriaArtista;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public CategoriaArtista getCategoriaArtista() {
        return categoriaArtista;
    }

    public List<Musica> getListaDeMusicas() {
        return listaDeMusicas;
    }

    public void setListaDeMusicas(List<Musica> listaDeMusicas) {
        this.listaDeMusicas = listaDeMusicas;
    }
}
