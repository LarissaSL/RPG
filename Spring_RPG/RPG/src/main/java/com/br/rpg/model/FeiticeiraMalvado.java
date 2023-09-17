package com.br.rpg.model;

public class FeiticeiraMalvado extends Feiticeira{
    public FeiticeiraMalvado() {
    }

    public FeiticeiraMalvado(String nome) {
        super(nome, 100, 40, 20, "Malvado");
        this.caminhoDaImg = "/img/personagens/feiticeiraMalvado.png";
        this.caminhoDaImgSimbolo = "/img/personagens/magoSimbolo.png";
    }

}
