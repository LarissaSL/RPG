package com.br.rpg.service;

import com.br.rpg.model.Boss;

import java.util.List;
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

    public String mensagemFimDaBatalha(){
        String mensagem;

        if (pontoPersonagem > pontoBoss){
            mensagem = "Parabéns Você Venceu! Vamos para a próxima etapa";
        } else if (pontoPersonagem == pontoBoss){
            mensagem = "Putz, empatou! Bora jogar de novo?";
        } else {
            mensagem = "Ah que pena, não foi dessa vez... Vamos tentar de novo?";
        }

        return mensagem;
    }
}




