package com.br.rpg.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public abstract class Personagem {
    protected String nome;
    protected int vida;
    protected int atq;
    protected int def;
    protected String personalidade;
    protected String caminhoDaImg;
    protected String caminhoDaImgSimbolo;

    //construtor
    public Personagem(){}
    public Personagem(String nome, int vida, int atq, int def, String personalidade) {
        this.nome = nome;
        this.vida = vida;
        this.atq = atq;
        this.def = def;
        this.personalidade = personalidade;
    }

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

    public String getCaminhoDaImg() {
        return this.caminhoDaImg;
    }

    public String getCaminhoDaImgSimbolo() {
        return this.caminhoDaImgSimbolo;
    }

    public void setCaminhoDaImg(String caminhoDaImg) {
        this.caminhoDaImg = caminhoDaImg;
    }

    public void setCaminhoDaImgSimbolo(String caminhoDaImgSimbolo) {
        this.caminhoDaImgSimbolo = caminhoDaImgSimbolo;
    }
}




