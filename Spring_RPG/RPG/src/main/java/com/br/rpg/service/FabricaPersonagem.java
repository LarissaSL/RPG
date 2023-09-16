package com.br.rpg.service;

import com.br.rpg.model.Feiticeira;
import com.br.rpg.model.Gladiadora;
import com.br.rpg.model.Guerreiro;
import com.br.rpg.model.Mago;


public interface FabricaPersonagem {
  Guerreiro criarGuerreiro();
  Mago criarMago();
  Gladiadora criarGladiadora();
  Feiticeira criarFeiticeira();

}
