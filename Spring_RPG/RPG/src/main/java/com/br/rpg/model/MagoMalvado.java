package com.br.rpg.model;

public class MagoMalvado extends Mago{
    public MagoMalvado() {
    }

    public MagoMalvado(String nome) {
        super(nome, 100, 40, 20, "Malvado");
        this.caminhoDaImg  = "/img/personagens/magoMalvado.png";
        this.caminhoDaImgSimbolo = "/img/personagens/magoSimbolo.png";
    }
}
