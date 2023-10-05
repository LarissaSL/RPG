package com.br.rpg.model;

public class MagoHeroico extends Mago{
    public MagoHeroico() {
    }

    public MagoHeroico(String nome) {
        super(nome, 100, 30, 30, "Heroico");
        setCaminhoDaImg("/img/personagens/magoHeroico.png");
        setCaminhoDaImgSimbolo("/img/personagens/magoSimbolo.png");
    }
}
