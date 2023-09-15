package com.br.rpg.services;

import com.br.rpg.model.Gladiadora;
import org.springframework.stereotype.Service;

@Service
public class FabricaPerssonagemMalvado implements FabricaPersonagem{

    @Override
    public Mago criarMago(){
        return new MagoMalvado;
    }

    @Override
    public Gladiadora criarGladiadora(){
        return new GladiadoraMalvada;
    }

    @Override
    public Feiticeira criarFeiticeira(){
        return new FeiticeiraMalvada;
    }

    @Override
    public Guerreiro criarGuerreiro(){
        return new GuerreiroMalvado;
    }

    //    Classe concreta para FabricaPerssonagemMalvado
    class MagoMalvado extends Mago{
        @Override
        public String classeHeroi(){
            return "Perssonagem" + this.classeHeroi() + ": Mago malvado";
        }
    }

    class GladiadoraMalvada extends Gladiadora {
        @Override
        public String classeHeroi(){
            return "Perssonagem" + this.classeHeroi() + ": Gladiadora malvada";
        }
    }

    class FeiticeiraMalvada extends Feiticeira{
        @Override
        public String classeHeroi(){
            return "Perssonagem" + this.classeHeroi() + ": Feiticeira malvada";
        }
    }

    class GuerreiroMalvado extends Guerreiro{
        @Override
        public String classeHeroi(){
            return "Perssonagem" + this.classeHeroi() + ": Guerreiro malvado";
        }
    }

}