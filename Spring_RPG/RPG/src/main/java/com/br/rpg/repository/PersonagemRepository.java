package com.br.rpg.repository;

import com.br.rpg.model.*;
import com.br.rpg.service.FabricaPersonagemHeroico;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Repository
public class PersonagemRepository {
    private final List<Personagem> personagemList = new ArrayList<>();
    private static final Logger logger = Logger.getLogger(PersonagemRepository.class.getName());

    private String nextNome = "nome";

    //Feiticeira Bot
    public PersonagemRepository() {
        FabricaPersonagemHeroico fabricaHeroico = new FabricaPersonagemHeroico();
        Personagem feiticeiroHeroico = fabricaHeroico.criarFeiticeira("Feiticeira Bot");
        personagemList.add(feiticeiroHeroico);
    }

    public List<Personagem> listarTodos() {
        return personagemList;
    }

    public Optional<Personagem> encontrarUltimoCadastrado() {
        List<Personagem> todosOsPersonagens = listarTodos();

        if (!todosOsPersonagens.isEmpty()) {
            Personagem ultimoCadastrado = todosOsPersonagens.get(todosOsPersonagens.size() - 1);
            return Optional.of(ultimoCadastrado);
        } else {
            return Optional.empty();
        }
    }


    public Optional<Personagem> listarPorNome(String nome) {
        return personagemList.stream().filter(personagem -> personagem.getNome().equals(nome)).findFirst();
    }

    public Personagem salvar(Personagem personagem) {
        if (personagem.getNome() == null || !existePersonagemComNome(personagem.getNome())) {
            /* Se o nome for nulo ou não existir um personagem com o mesmo nome, adiciona na lista, se tiver mesmo nome
            ele informa no console e não realiza nada*/
            if (personagem.getNome() == null) {
                personagem.setNome(nextNome);
            }
            personagemList.add(personagem);
            logger.info("Novo personagem adicionado: " + personagem.getNome());
        } else {
            logger.warning("Já existe um personagem com o nome: " + personagem.getNome());
        }
        return personagem;
    }

    private boolean existePersonagemComNome(String nome) {
        return personagemList.stream().anyMatch(personagem -> personagem.getNome().equals(nome));
    }


    public void deletarPorNome(String nome) {
        personagemList.removeIf(personagem -> personagem.getNome().equals(nome));
    }
}
