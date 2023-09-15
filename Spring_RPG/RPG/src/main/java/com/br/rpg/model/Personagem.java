package com.br.rpg.model;

public abstract class Personagem {
    protected String nome;
    protected int vida;
    protected int atq;
    protected int def;

    //construtor
    public Personagem(String nome, int vida, int atq, int def) {
        this.nome = nome;
        this.vida = vida;
        this.atq = atq;
        this.def = def;
    }

    //métodos
    public void realizarAtaque(){}
    public void realizarDefeza(){}

    //getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtq() {
        return atq;
    }

    public void setAtq(int atq) {
        this.atq = atq;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }
}




