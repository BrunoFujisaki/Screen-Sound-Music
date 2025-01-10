package com.meusite.screensoundmusic.model;

import jakarta.persistence.*;

@Entity
@Table(name = "musicas")
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String musica;
    private String album;
    @ManyToOne
    private Artista artista;

    @Deprecated
    public Musica() {
    }

    public Musica(String musica, String album) {
        this.musica = musica;
        this.album = album;
    }

    public Long getId() {
        return id;
    }

    public String getMusica() {
        return musica;
    }

    public String getAlbum() {
        return album;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }
}
