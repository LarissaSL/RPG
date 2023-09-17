package com.br.rpg.model;

public abstract class Gladiadora extends Personagem{
    public Gladiadora() {
    }

    public Gladiadora(String nome, int vida, int atq, int def, String personalidade) {
        super(nome, vida, atq, def, personalidade);
    }

}