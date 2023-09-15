package com.br.rpg.services;


import com.br.rpg.model.Gladiadora;
import org.springframework.stereotype.Service;

@Service
public class FabricaPerssonagemHeroico implements FabricaPersonagem {

    @Override
    public Mago criarMago(){
        return new MagoHeroico;
    }

    @Override
    public Gladiadora criarGladiadora(){
        return new GladiadoraHeroica;
    }

    @Override
    public Feiticeira criarFeiticeira(){
        return new FeiticeiraHeroica;
    }

    @Override
    public Guerreiro criarGuerreiro(){
        return new GuerreiroHeroico;
    }

//    Classe Concreta para FabricaPerssonagemHeroico
    class MagoHeroico extends Mago{
    @Override
    public String classeHeroi(){
            return "Perssonagem" + this.classeHeroi() + ": Mago Heroico";
        }
    }

    class GladiadoraHeroica extends Gladiadora {
        @Override
        public String classeHeroi(){
            return "Perssonagem" + this.classeHeroi() + ": Gladiadora Heroica";
        }
    }

    class FeiticeiraHeroica extends Feiticeira{
        @Override
        public String classeHeroi(){
            return "Perssonagem" + this.classeHeroi() + ": Feiticeira Heroico";
        }
    }

    class GuerreiroHeroico extends Guerreiro{
        @Override
        public String classeHeroi(){
            return "Perssonagem" + this.classeHeroi() + ": Guerreiro Heroico";
        }
    }

}