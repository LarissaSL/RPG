package com.br.rpg.model;

public class MagoMalvado extends Mago{
    public MagoMalvado() {
    }

    public MagoMalvado(String nome) {
        super(nome, 100, 35, 20, "Malvado");
        setCaminhoDaImg("/img/personagens/magoMalvado.png");
        setCaminhoDaImgSimbolo("/img/personagens/magoSimbolo.png");
    }
}
