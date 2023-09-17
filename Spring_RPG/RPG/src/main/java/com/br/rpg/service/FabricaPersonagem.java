package com.br.rpg.service;

import com.br.rpg.model.Feiticeira;
import com.br.rpg.model.Gladiadora;
import com.br.rpg.model.Guerreiro;
import com.br.rpg.model.Mago;


public interface FabricaPersonagem {
  Guerreiro criarGuerreiro(String nome);
  Mago criarMago(String nome);
  Gladiadora criarGladiadora(String nome);
  Feiticeira criarFeiticeira(String nome);

}
