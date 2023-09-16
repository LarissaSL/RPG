package com.br.rpg.service;


import com.br.rpg.model.Personagem;
import com.br.rpg.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PersonagemService {
    private final PersonagemRepository personagemRepository;

    @Autowired
    public PersonagemService(PersonagemRepository personagemRepository) {
        this.personagemRepository = personagemRepository;
    }

    public List<Personagem> listarTodos() {

        return personagemRepository.listarTodos();
    }

    public Optional<Personagem> listarPorNome(String nome) {
        return personagemRepository.listarPorNome(nome);
    }

    public Personagem salvar(Personagem personagem) {

        return personagemRepository.salvar(personagem);
    }

    public void deletarPorNome(String nome) {

        personagemRepository.deletarPorNome(nome);
    }
}
