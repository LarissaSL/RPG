package com.br.rpg.model;

public class GladiadoraMalvado extends Gladiadora{
    public GladiadoraMalvado() {
    }

    public GladiadoraMalvado(String nome) {
        super(nome, 100, 42, 20, "Malvado");
        setCaminhoDaImg("/img/personagens/gladiadoraMalvado.png");
        setCaminhoDaImgSimbolo("/img/personagens/guerreiroSimbolo.png");
    }
}
