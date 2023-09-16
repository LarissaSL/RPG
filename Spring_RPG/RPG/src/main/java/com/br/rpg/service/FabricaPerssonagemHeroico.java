package com.br.rpg.service;


import com.br.rpg.model.Feiticeira;
import com.br.rpg.model.Gladiadora;
import com.br.rpg.model.Guerreiro;
import com.br.rpg.service.FabricaPersonagem;
import org.springframework.stereotype.Service;

@Service
public class FabricaPerssonagemHeroico implements FabricaPersonagem {

    @Override
    public Mago criarMago(){
        return new MagoHeroico();
    }

    @Override
    public Gladiadora criarGladiadora(){
        return new GladiadoraHeroico();
    }

    @Override
    public Feiticeira criarFeiticeira(){
        return new FeiticeiraHeroico();
    }

    @Override
    public Guerreiro criarGuerreiro(){
        return new GuerreiroHeroico();
    }

    //    Classe abstrata para FabricaPerssonagemMalvado
    abstract class Mago{
        protected String classeHeroi;

        public Mago() {
            this.classeHeroi = "Heroico";
        }

        public abstract String classeHeroi();
    }

    //    Classe Concreta para FabricaPerssonagemHeroico
    class MagoHeroico extends Mago {
        @Override
        public String classeHeroi(){
            return "Perssonagem " + this.classeHeroi() + ": Mago ";
        }
    }

    class GladiadoraHeroico extends Gladiadora {
        @Override
        public String classeHeroi(){
            return "Perssonagem " + this.classeHeroi() + ": Gladiadora";
        }
    }

    class FeiticeiraHeroico extends Feiticeira{
        @Override
        public String classeHeroi(){
            return "Perssonagem " + this.classeHeroi() + ": Feiticeira ";
        }
    }

    class GuerreiroHeroico extends Guerreiro{
        @Override
        public String classeHeroi(){
            return "Perssonagem " + this.classeHeroi() + ": Guerreiro ";
        }
    }

}