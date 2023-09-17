package com.br.rpg.model;

public abstract class Feiticeira extends Personagem {
    public Feiticeira() {
    }
    public Feiticeira(String nome, int vida, int atq, int def, String personalidade) {
        super(nome, vida, atq, def, personalidade);
    }
}

