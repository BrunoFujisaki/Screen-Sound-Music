package com.meusite.screensoundmusic.model;

public enum CategoriaArtista {
    SOLO("solo"),
    DUPLA("dupla"),
    BANDA("banda");

    private String categoriaString;

    CategoriaArtista(String categoriaString) {
        this.categoriaString = categoriaString;
    }

    public static CategoriaArtista fromString(String tipoArtista){
        for (CategoriaArtista categoria : CategoriaArtista.values()){
            if (categoria.categoriaString.equalsIgnoreCase(tipoArtista)){
                return categoria;
            }
        }
        throw new IllegalArgumentException("Categoria não encontrada");
    }
}
