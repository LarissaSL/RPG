package com.br.rpg.model;

public abstract class Mago extends Personagem {
    public Mago() {
    }

    public Mago(String nome, int vida, int atq, int def, String personalidade) {
        super(nome, vida, atq, def, personalidade);
    }
}

