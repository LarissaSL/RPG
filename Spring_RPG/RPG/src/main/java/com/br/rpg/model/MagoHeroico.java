package com.br.rpg.model;

public class MagoHeroico extends Mago{
    public MagoHeroico() {
    }

    public MagoHeroico(String nome) {
        super(nome, 100, 30, 30, "Heroico");
        this.caminhoDaImg = "/img/personagens/magoHeroico.png";
        this.caminhoDaImgSimbolo = "/img/personagens/magoSimbolo.png";
    }
}
