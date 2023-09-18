package com.br.rpg.controller;

import com.br.rpg.model.Boss;
import com.br.rpg.model.Personagem;
import com.br.rpg.repository.PersonagemRepository;
import com.br.rpg.service.*;
import com.br.rpg.service.BossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    //Colocando os repositorios
    private final BossService bossService;
    private final PersonagemRepository personagemRepository;
    private FabricaPersonagemHeroico fabricaHeroico;
    private FabricaPersonagemMalvado fabricaMalvado;

    @Autowired
    public HomeController(BossService bossService, PersonagemRepository personagemRepository,
                          FabricaPersonagemHeroico fabricaHeroico, FabricaPersonagemMalvado fabricaMalvado ) {
        this.bossService = bossService;
        this.personagemRepository = personagemRepository;
        this.fabricaHeroico = fabricaHeroico;
        this.fabricaMalvado = fabricaMalvado;
    }


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/cadastro")
    public String cadastro(){
        return "cadastro";
    }
    @PostMapping("/cadastro")
    public String cadastrarPersonagem(@RequestParam("nomeJogador") String nomeJogador,
                                      @RequestParam("personagem") String personagem,
                                      @RequestParam("personalidade") String personalidade) {

        // Decidindo qual fábrica vamos usar com base na personalidade
        FabricaPersonagem fabrica = personalidade.equals("Heroico") ? fabricaHeroico : fabricaMalvado;

        // Utilize a fábrica apropriada para criar o personagem com base nas escolhas do jogador
        Personagem novoPersonagem;
        switch (personagem) {
            case "Gladiadora":
                novoPersonagem = fabrica.criarGladiadora(nomeJogador);
                break;
            case "Guerreiro":
                novoPersonagem = fabrica.criarGuerreiro(nomeJogador);
                break;
            case "Mago":
                novoPersonagem = fabrica.criarMago(nomeJogador);
                break;
            case "Feiticeira":
                novoPersonagem = fabrica.criarFeiticeira(nomeJogador);
                break;
            default:
                return "redirect:/cadastro?erro=invalido";
        }

        // Salvar o novo personagem no repositório
        personagemRepository.salvar(novoPersonagem);

        // Por enquanto mandei pra um HTML improvisado de Personagens só pra ver se ta salvando msm certo os cadastrados
        //ALTERAR ISSO DEPOIS PRA IR DIRETO PRA PAGINA DE BATALHAS
        return "redirect:/personagens";
    }


    @GetMapping("/batalha")
    public String batalha(Model model) {
        List<Boss> bosses = bossService.listarTodos();
        model.addAttribute("bosses", bosses);
        return "batalha";
    }

    //TEstar pra ver as instancias dos Personagens TIRAR DEPOIS
    @GetMapping("/personagens")
    public String listarPersonagens(Model model) {
        List<Personagem> personagens = personagemRepository.listarTodos();
        model.addAttribute("personagens", personagens);
        return "personagens";
    }

    @GetMapping("/rodada")
    public String rodada(Model model) {

        List<Boss> bosses = bossService.listarTodos();
        model.addAttribute("bosses", bosses);

        List<Personagem> personagens = personagemRepository.listarTodos();
        if (!personagens.isEmpty()) {
            Personagem ultimoPersonagem = personagens.get(personagens.size() - 1);
            model.addAttribute("ultimoPersonagem", ultimoPersonagem);
        }
        /*Essa parte do Codigo vai dentro de um IF, Se a vitoria for igual a S então
        o bosses.get(0) tem que incrementar 1 se não inicia do 0
        Boss bossAtual = bosses.get(2);
        model.addAttribute("bossAtual", bossAtual);
        */


        return "rodadas";
    }

    //Criar o PostMapping do rodadas, para ter dinamismo na pagina
    @PostMapping("/rodada")
    public String rodada(@RequestParam("acaoJogador") int acaoJogador){
        /* Aqui entra as opções do Usuario de atk e defesa
        2 - Chamar o metodo da Classe Rodada que tem o sistema de Pontuar
        3 - Mostra a mensagem do que rolou nessa rodada (ex.Minotauro atacou!)

        4 - Repete o passo 1 ao 3 por 3 vezes
        5 - Quando for a 3 rodada tem que mostrar se você ganhou, perdeu ou empatou e ai modificar
        o Boss se necessario vai logica do IF dnv
         */

        return "redirect:/rodada?acao=true";

    }
}
