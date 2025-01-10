# 🎵 ScreenSoundMusic

ScreenSoundMusic é um mini-projeto desenvolvido como parte de um desafio proposto pela Alura. O sistema tem como objetivo gerenciar artistas e músicas, implementado em Java utilizando o framework Spring Boot.

## 📋 Funcionalidades

- **Cadastro de artistas**: Permite o registro de novos artistas no sistema, com categorias definidas como solo, dupla ou banda.
- **Cadastro de músicas**: Relaciona músicas aos artistas cadastrados, informando o nome e o álbum.
- **Listagem de músicas**: Exibe todas as músicas cadastradas, juntamente com as informações de artista e álbum.
- **Busca de músicas por artista**: Realiza a busca de músicas vinculadas a um artista específico.

## 🛠️ Tecnologias Utilizadas

- **Java 23**
- **Spring Boot**
- **Spring Data JPA**
- **PostgreSQL** (Banco de dados para persistência)

## 🗂️ Estrutura do Projeto

- **`ScreenSoundMusicApplication`**: Classe principal responsável por iniciar a aplicação Spring Boot.
- **`Principal`**: Controlador de menu interativo, permitindo ao usuário navegar pelas funcionalidades de cadastro, listagem e busca.
- **`Artista`**: Entidade que representa os artistas, incluindo o nome e a categoria (solo, dupla, banda).
- **`Musica`**: Entidade que representa as músicas, com informações sobre o nome da música e o álbum, associada a um artista.
- **`ArtistaRepository`**: Interface que lida com a persistência no banco de dados, oferecendo métodos para buscas personalizadas.
- **`CategoriaArtista`**: Enum que define as possíveis categorias de artistas (solo, dupla, banda).

## 🌱 Variáveis de Ambiente

O projeto utiliza variáveis de ambiente para gerenciar informações sensíveis, como credenciais de banco de dados e configurações específicas. Essas variáveis são configuradas no ambiente de execução para garantir maior segurança e flexibilidade.

## 📚 Curso

Este projeto foi desenvolvido no curso **"Java: Persistência de Dados e Consultas com Spring Data JPA"** da [Alura](https://www.alura.com.br/). O desafio final consistiu em:

1. Implementar a lógica de persistência utilizando Spring Data JPA.
2. Criar um menu dinâmico e interativo no terminal.
3. Relacionar as entidades `Artista` e `Musica`.
4. Utilizar o banco de dados PostgreSQL para persistência.
