package com.br.rpg.service;

import com.br.rpg.model.*;
import org.springframework.stereotype.Component;

@Component("fabricaMalvado")
public class FabricaPersonagemMalvado implements FabricaPersonagem {

    @Override
    public Mago criarMago(String nome) {
        return new MagoMalvado(nome);
    }

    @Override
    public Gladiadora criarGladiadora(String nome) {
        return new GladiadoraMalvado(nome);
    }

    @Override
    public Feiticeira criarFeiticeira(String nome) {
        return new FeiticeiraMalvado(nome);
    }

    @Override
    public Guerreiro criarGuerreiro(String nome) {
        return new GuerreiroMalvado(nome);
    }

}