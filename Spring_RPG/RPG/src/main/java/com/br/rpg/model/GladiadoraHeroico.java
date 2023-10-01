package com.br.rpg.model;

public class GladiadoraHeroico extends Gladiadora{
    public GladiadoraHeroico() {
    }

    public GladiadoraHeroico(String nome) {
        super(nome, 100, 43, 30, "Heroico");
        setCaminhoDaImg("/img/personagens/gladiadoraHeroico.png");
        setCaminhoDaImgSimbolo("/img/personagens/guerreiroSimbolo.png");
    }
}
