package com.br.rpg.model;

public class GladiadoraMalvado extends Gladiadora{
    public GladiadoraMalvado() {
    }

    public GladiadoraMalvado(String nome) {
        super(nome, 100, 40, 20, "Malvado");
        this.caminhoDaImg = "/img/personagens/gladiadoraMalvado.png";
        this.caminhoDaImgSimbolo = "/img/personagens/guerreiroSimbolo.png";
    }
}
