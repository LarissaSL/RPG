package com.br.rpg.model;

public class FeiticeiraMalvado extends Feiticeira{
    public FeiticeiraMalvado() {
    }

    public FeiticeiraMalvado(String nome) {
        super(nome, 100, 37, 20, "Malvado");
        setCaminhoDaImg("/img/personagens/feiticeiraMalvado.png");
        setCaminhoDaImgSimbolo("/img/personagens/magoSimbolo.png");
    }

}
