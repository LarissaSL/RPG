package com.br.rpg.service;

import com.br.rpg.model.Boss;

import java.util.List;

public class Rodadas {
    public int pontoPersonagem;
    public int pontoBoss;

    public String vitoria;


    public String getVitoria() {
        return vitoria;
    }

    public void setVitoria(String vitoria) {
        this.vitoria = vitoria;
    }

    public String mensagemFimDaBatalha(){
        String mensagem;

        if (pontoPersonagem > pontoBoss){
            mensagem = "Parabéns Você Venceu! Vamos para a próxima etapa";
            setVitoria("S");
            // bossAtual++ para pegar o Cerbero
        } else if (pontoPersonagem == pontoBoss){
            mensagem = "Putz, empatou! Bora jogar de novo?";
            setVitoria("N");
        } else {
            mensagem = "Ah que pena, não foi dessa vez... Vamos tentar de novo?";
            setVitoria("N");
        }

        return mensagem;
    }
    // metodo de pontuação
                System.out.println("Rodada " + rodada + ": Personagem atacou, Boss nao atacou - Boss ganha ponto\n");
                pontosBoss++;
            }
        } else {
            if (golpesB == 1) {
                System.out.println("Rodada " + rodada + ": Personagem defendeu, Boss atacou - Personagem ganha ponto\n");
                pontosPersonagem++;
            } else {
                System.out.println("Rodada " + rodada + ": Personagem defendeu, Boss nao atacou - ninguem ganha pontos\n");
            }
        }
    }

        System.out.println("Total de pontos do Personagem: " + pontosPersonagem);
        System.out.println("Total de pontos do Boss: " + pontosBoss);
}
}




