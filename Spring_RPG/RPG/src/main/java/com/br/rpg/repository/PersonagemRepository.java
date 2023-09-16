package com.br.rpg.repository;

import com.br.rpg.model.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonagemRepository {
    private final List<Personagem> personagemList = new ArrayList<>();
    private String nextNome = "nome";

    //Construtor que já Instancia Personagem padrão do RPG
    public PersonagemRepository() {
        Mago mago = new Mago();
        mago.setNome("Mago");
        mago.setVida(150);
        mago.setAtq(20);
        mago.setDef(20);
        personagemList.add(mago);


        Gladiadora gladiadora = new Gladiadora();
        gladiadora.setNome("Gladiadora");
        gladiadora.setVida(150);
        gladiadora.setAtq(20);
        gladiadora.setDef(20);
        personagemList.add(gladiadora);


        Feiticeira feiticeira = new Feiticeira();
        feiticeira.setNome("Feiticeira");
        feiticeira.setVida(150);
        feiticeira.setAtq(20);
        feiticeira.setDef(20);
        personagemList.add(feiticeira);


        Guerreiro gerreiro = new Guerreiro();
        gerreiro.setNome("Gerreiro");
        gerreiro.setVida(150);
        gerreiro.setAtq(20);
        gerreiro.setDef(20);

        personagemList.add(gerreiro);
    }

    public List<Personagem> listarTodos() {

        return personagemList;
    }

    public Optional<Personagem> listarPorNome(String nome) {
        return personagemList.stream().filter(personagem -> personagem.getNome().equals(nome)).findFirst();
    }

    public Personagem salvar(Personagem personagem) {
        if (personagem.getNome() == null) {
            personagem.setNome(nextNome);
            personagemList.add(personagem);
        } else {
            personagemList.replaceAll(existingPersonagem -> {
                if (existingPersonagem.getNome().equals(personagem.getNome())) {
                    return personagem;
                }
                return existingPersonagem;
            });
        }
        return personagem;
    }

    public void deletarPorNome(String nome) {
        personagemList.removeIf(personagem -> personagem.getNome().equals(nome));
    }
}
