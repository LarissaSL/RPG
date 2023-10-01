package com.br.rpg.model;

public class GuerreiroHeroico extends Guerreiro{
    public GuerreiroHeroico() {
    }

    public GuerreiroHeroico(String nome) {
        super(nome, 100, 45, 30, "Heroico");
        this.caminhoDaImg = "/img/personagens/guerreiroHeroico.png";
        this.caminhoDaImgSimbolo = "/img/personagens/guerreiroSimbolo.png";
    }
}
