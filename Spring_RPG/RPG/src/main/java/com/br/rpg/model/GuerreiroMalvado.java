package com.br.rpg.model;

public class GuerreiroMalvado extends Guerreiro{
    public GuerreiroMalvado() {
    }

    public GuerreiroMalvado(String nome) {
        super(nome, 100, 40, 20, "Malvado");
        setCaminhoDaImg("/img/personagens/guerreiroMalvado.png");
        setCaminhoDaImgSimbolo("/img/personagens/guerreiroSimbolo.png");
    }

}
