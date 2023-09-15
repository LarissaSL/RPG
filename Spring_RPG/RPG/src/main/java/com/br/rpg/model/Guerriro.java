package com.br.rpg.model;

public class Guerriro extends Personagem{
    private int golpeEspecial;
    //    UM ATAQUE EESPECIAL UNICO DO PERSONAGEM

    public Guerriro (String nome, int vida, int atq, int def, int golpeEspecial){
        super(nome, vida, atq, def);

        this.golpeEspecial = golpeEspecial;

    }

    public int getGolpeEspecial() {
        return golpeEspecial;
    }

    public void setGolpeEspecial(int golpeEspecial) {
        this.golpeEspecial = golpeEspecial;
    }

    //Medtodo ataque e defesa
//    public void atacar() {
//        System.out.println(getNome() + " atacou!");
//    }
//
//    public void defender() {
//        System.out.println(getNome() + " defendeu!");
//    }
}