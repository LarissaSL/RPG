package com.br.rpg.model;

public abstract class Mago extends Personagem {
    public Mago(String nome, int vida, int atq, int def) {
        super(nome, vida, atq, def);
    }
    public abstract String classeMalvado();

    public abstract String classeHeroi();
}

