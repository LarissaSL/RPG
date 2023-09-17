package com.br.rpg.model;

public class FeiticeiraHeroico extends Feiticeira{
    public FeiticeiraHeroico() {
    }

    public FeiticeiraHeroico(String nome) {
        super(nome, 100, 30, 30, "Heroico");
        this.caminhoDaImg = "/img/personagens/feiticeiraHeroico.png";
        this.caminhoDaImgSimbolo = "/img/personagens/magoSimbolo.png";
    }
}
