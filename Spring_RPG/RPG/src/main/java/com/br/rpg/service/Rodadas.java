package com.br.rpg.service;

import java.util.Scanner;

public class Rodadas {
    public int atqP = 1;
    public int defP = 0;
    public int pontoPersonagem;
    public int pontoBoss;

    private Scanner random;
    public int atqB = random.nextInt(1);
    public int defB = random.nextInt(1);

    public int executar(){
        if(atqP == atqB){
            pontoPersonagem +=1;
            pontoBoss +=1;

        }
        return 0;
    }
}




