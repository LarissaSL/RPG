package com.br.rpg.model;

public abstract class Guerreiro extends Personagem{
    public Guerreiro() {
    }

    public Guerreiro(String nome, int vida, int atq, int def, String personalidade) {
        super(nome, vida, atq, def, personalidade);
    }
}