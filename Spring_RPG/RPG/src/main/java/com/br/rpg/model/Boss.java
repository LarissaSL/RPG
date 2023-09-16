package com.br.rpg.model;

public class Boss  {
    private int id;
    private String nome;
    private String dificuldade;
    private int vida;
    private int atq;
    private int def;
    private String descricao;
    private String caminhoImg;

    private String caminhoImgSimbolo;

    //Construtores, 1 padrao sem argumentos e outro com todos os argumentos
    public Boss(){}

    public Boss(int id, String nome, String dificuldade, int vida, int atq, int def, String descricao) {
        this.id = id;
        this.nome = nome;
        this.dificuldade = dificuldade;
        this.vida = vida;
        this.atq = atq;
        this.def = def;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCaminhoDaImg() {
        String nome = this.nome.toLowerCase();
        return "/img/personagens/" + nome + ".png";
    }
    public void setCaminhoImg(String caminhoImg) {
        this.caminhoImg = caminhoImg;
    }

    public String getCaminhoDaImgSimbolo() {
        String nome = this.nome.toLowerCase();
        return "/img/personagens/" + nome + "Simbolo.png";
    }
    public void setCaminhoImgSimbolo(String caminhoImgSimbolo) {
        this.caminhoImg = caminhoImg;
    }
}


