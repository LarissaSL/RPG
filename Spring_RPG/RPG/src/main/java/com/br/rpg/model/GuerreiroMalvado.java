package com.br.rpg.model;

public class GuerreiroMalvado extends Guerreiro{
    public GuerreiroMalvado() {
    }

    public GuerreiroMalvado(String nome) {
        super(nome, 100, 40, 20, "Malvado");
        this.caminhoDaImg = "/img/personagens/guerreiroMalvado.png";
        this.caminhoDaImgSimbolo = "/img/personagens/guerreiroSimbolo.png";
    }

}
