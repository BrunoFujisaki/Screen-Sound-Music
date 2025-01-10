package com.meusite.screensoundmusic.main;

import com.meusite.screensoundmusic.model.Artista;
import com.meusite.screensoundmusic.model.CategoriaArtista;
import com.meusite.screensoundmusic.model.Musica;
import com.meusite.screensoundmusic.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Principal {
    @Autowired
    private ArtistaRepository artistaRepository;
    private Scanner sc = new Scanner(System.in);
    public void exibirMenu(){
        var op = 0;
        while (op != 9) {
            var menu = """
                    1 - Cadastrar artistas
                    2 - Cadastrar músicas
                    3 - Listar músicas
                    4 - Buscar músicas por artistas
                    
                    9 - Sair
                    """;
            System.out.println(menu);
            op = sc.nextInt();
            sc.nextLine();
            switch (op) {
                case 1:
                    cadastrarArtistas();
                    break;
                case 2:
                    cadastrarMusicas();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicasPorArtistas();
                    break;
                case 9:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private void cadastrarArtistas() {
        var op = 1;
        while (op != 0){
            System.out.println("Informe o nome desse artista: ");
            var nomeDoArtista = sc.nextLine();
            System.out.println("Informe o tipo desse artista: (solo/dupla/banda)");
            var categoriaDoArtista = sc.nextLine();
            Artista artista = new Artista(nomeDoArtista, CategoriaArtista.fromString(categoriaDoArtista));
            artistaRepository.save(artista);
            System.out.println("1 - Cadastrar outro artista\n0 - Voltar para o menu");
            op = sc.nextInt();
            sc.nextLine();
        }
    }

    private void cadastrarMusicas() {
        listarArtistas();
        var op = 1;
        while (op != 0){
            System.out.println("\nInforme o nome do artista: ");
            var nomeDoArtista = sc.nextLine();

            artistaRepository.buscarArtista(nomeDoArtista).ifPresentOrElse(a -> {
                System.out.println("Informe o nome da música");
                var nomeDaMusica = sc.nextLine();
                System.out.println("Informe o nome do álbum: ");
                var nomeDoAlbum = sc.nextLine();
                Musica musica = new Musica(nomeDaMusica, nomeDoAlbum);
                musica.setArtista(a);
                a.getListaDeMusicas().add(musica);
                artistaRepository.save(a);
            }, () -> System.out.println("Artista não encontrado!"));

            System.out.println("1 - Cadastrar outra música\n0 - Voltar para o menu");
            op = sc.nextInt();
            sc.nextLine();
        }
    }

    private void listarMusicas() {
        artistaRepository.findAll().forEach(a -> {
            a.getListaDeMusicas().forEach(m -> {
                System.out.println(" - Música: " + m.getMusica() + ", Álbum: " + m.getAlbum() + ", Artista: " + m.getArtista().getNome());
            });
        });
    }

    private void buscarMusicasPorArtistas() {
        listarArtistas();
        var op = 1;
        while (op != 0){
            System.out.println("\nInforme o nome do artista: ");
            var nomeDoArtista = sc.nextLine();

            artistaRepository.buscarArtista(nomeDoArtista).ifPresentOrElse(a -> {
                a.getListaDeMusicas().forEach(m -> {
                    System.out.println("Música: " + m.getMusica() + ", Álbum: " + m.getAlbum());
                });

            }, () -> System.out.println("Artista não encontrado!"));

            System.out.println("1 - Buscar outor artista\n0 - Voltar para o menu");
            op = sc.nextInt();
            sc.nextLine();
        }
    }

    private void listarArtistas(){
        artistaRepository.findAll().forEach(a -> {
            System.out.println("Artista: " + a.getNome() + ", Tipo: " + a.getCategoriaArtista());
        });
    }
}
