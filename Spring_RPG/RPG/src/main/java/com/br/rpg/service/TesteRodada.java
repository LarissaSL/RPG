package com.br.rpg.service;

import java.util.Random;

public class TesteRodada {
    public static void main(String[] args) {

        //C
        Random rand = new Random();

        int totalRodadas = 3;
        int pontosPersonagem = 0;
        int pontosBoss = 0;

        for (int rodada = 1; rodada <= totalRodadas; rodada++) {
            int golpesB = rand.nextInt(2);
            int golpesP = rand.nextInt(2);

            if (golpesP == 1) {
                if (golpesB == 1) {
                    System.out.println("Rodada " + rodada + ": Personagem atacou, Boss atacou - os dois ganham pontos\n");
                    pontosPersonagem++;
                    pontosBoss++;
                } else {
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
