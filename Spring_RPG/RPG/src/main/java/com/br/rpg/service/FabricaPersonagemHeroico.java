package com.br.rpg.service;


import com.br.rpg.model.*;
import org.springframework.stereotype.Component;

@Component("fabricaHeroico")
public class FabricaPersonagemHeroico implements FabricaPersonagem {

    @Override
    public Mago criarMago(String nome) {
        return new MagoHeroico(nome);
    }

    @Override
    public Gladiadora criarGladiadora(String nome) {
        return new GladiadoraHeroico(nome);
    }

    @Override
    public Feiticeira criarFeiticeira(String nome) {
        return new FeiticeiraHeroico(nome);
    }

    @Override
    public Guerreiro criarGuerreiro(String nome) {
        return new GuerreiroHeroico(nome);
    }

}