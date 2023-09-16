package com.br.rpg.service;

import com.br.rpg.model.Feiticeira;
import com.br.rpg.model.Gladiadora;
import com.br.rpg.model.Guerreiro;
import com.br.rpg.model.Mago;
import com.br.rpg.service.FabricaPersonagem;
import org.springframework.stereotype.Service;

@Service
public class FabricaPerssonagemMalvado implements FabricaPersonagem {

    @Override
    public Mago criarMago(){
        return new MagoMalvado();
    }

    @Override
    public Gladiadora criarGladiadora(){
        return new GladiadoraMalvado();
    }

    @Override
    public Feiticeira criarFeiticeira(){
        return new FeiticeiraMalvado();
    }

    @Override
    public Guerreiro criarGuerreiro(){
        return new GuerreiroMalvado();
    }

    //    Classe abstrata para FabricaPerssonagemMalvado
    abstract class Mago{
        protected String classeMalvado;

        public Mago() {
            this.classeMalvado = "Malvado";
        }

        public abstract String classeMalvado();
    } // FIZ COMO TESTE PARA VER SE SOME O ERRO DA CLASSE

    //    Classe concreta para FabricaPerssonagemMalvado
    class MagoMalvado extends Mago{
        @Override
        public String classeMalvado(){
            return "Perssonagem" + this.classeMalvado() + ": Mago";
        }
    }

    class GladiadoraMalvado extends Gladiadora {
        @Override
        public String classeMalvado(){
            return "Perssonagem" + this.classeMalvado() + ": Gladiadora";
        }
    }

    class FeiticeiraMalvado extends Feiticeira{
        @Override
        public String classeMalvado(){
            return "Perssonagem" + this.classeMalvado() + ": Feiticeira";
        }
    }

    class GuerreiroMalvado extends Guerreiro{
        @Override
        public String classeMalvado(){
            return "Perssonagem" + this.classeMalvado() + ": Guerreiro";
        }
    }

}