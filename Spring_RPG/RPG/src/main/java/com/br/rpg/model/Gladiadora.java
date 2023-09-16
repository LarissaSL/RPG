package com.br.rpg.model;


public class Gladiadora extends Personagem{

    private int ultimatoGolpe;
//    UM ATAQUE EESPECIAL UNICO DO PERSONAGEM

    public Gladiadora(String nome, int vida, int atq, int def, int ultimatoGolpe){
        super(nome, vida, atq, def);
        this.ultimatoGolpe = ultimatoGolpe;

    }

    public int getUltimatoGolpe() {
        return ultimatoGolpe;
    }

    public void setUltimatoGolpe(int ultimatoGolpe) {
        this.ultimatoGolpe = ultimatoGolpe;
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