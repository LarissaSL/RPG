package com.br.rpg.model;

public class FeiticeiraHeroico extends Feiticeira{
    public FeiticeiraHeroico() {
    }

    public FeiticeiraHeroico(String nome) {
        super(nome, 100, 38, 30, "Heroico");
        setCaminhoDaImg("/img/personagens/feiticeiraHeroico.png");
        setCaminhoDaImgSimbolo("/img/personagens/magoSimbolo.png");
    }
}
