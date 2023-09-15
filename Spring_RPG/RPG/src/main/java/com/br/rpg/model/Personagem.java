package com.br.rpg.model;

public abstract class Personagem {
    protected String nome;
    protected int vida;
    protected int atq;
    protected int def;
    private Atacar ataque;
    private Defender defende;

    public Personagem(String nome, int vida, int atq, int def) {
        this.nome = nome;
        this.vida = vida;
        this.atq = atq;
        this.def = def;

    }

    //pegue esse método no chatgpt para entender melhor como construí-los
    public void realizarAtaque(Personagem alvo){
        ataque.executar(this, alvo);
    }
    public void realizarDefeza(int dano){
        defende.executar(this, dano);
    }

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

    public Atacar getAtacar() {
        return atacar;
    }

    public void setAtacar(Atacar atacar) {
        this.atacar = atacar;
    }

    public Defender getDefender() {
        return defender;
    }

    public void setDefender(Defender defender) {
        this.defender = defender;
    }
}




