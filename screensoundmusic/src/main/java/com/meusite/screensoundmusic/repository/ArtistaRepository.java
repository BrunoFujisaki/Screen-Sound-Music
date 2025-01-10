package com.meusite.screensoundmusic.repository;

import com.meusite.screensoundmusic.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {
    @Query("SELECT a FROM Artista a WHERE a.nome ILIKE %:nomeDoArtista%")
    Optional<Artista> buscarArtista(String nomeDoArtista);
}
