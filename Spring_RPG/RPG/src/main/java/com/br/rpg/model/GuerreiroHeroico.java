package com.br.rpg.model;

public class GuerreiroHeroico extends Guerreiro{
    public GuerreiroHeroico() {
    }

    public GuerreiroHeroico(String nome) {
        super(nome, 100, 45, 30, "Heroico");
        setCaminhoDaImg("/img/personagens/guerreiroHeroico.png");
        setCaminhoDaImgSimbolo("/img/personagens/guerreiroSimbolo.png");
    }
}
