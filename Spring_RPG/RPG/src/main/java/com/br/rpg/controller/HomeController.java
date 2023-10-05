package com.br.rpg.controller;

import com.br.rpg.model.Boss;
import com.br.rpg.model.Personagem;
import com.br.rpg.repository.PersonagemRepository;
import com.br.rpg.service.*;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    private Rodadas rodadas;




    @Autowired
    public HomeController(BossService bossService, PersonagemRepository personagemRepository,
                          FabricaPersonagemHeroico fabricaHeroico, FabricaPersonagemMalvado fabricaMalvado,
                          Rodadas rodadas) {
        this.bossService = bossService;
        this.personagemRepository = personagemRepository;
        this.fabricaHeroico = fabricaHeroico;
        this.fabricaMalvado = fabricaMalvado;
        this.rodadas = rodadas;
    }


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrarPersonagem(@RequestParam("nomeJogador") String nomeJogador,
                                      @RequestParam("personagem") String personagem,
                                      @RequestParam("personalidade") String personalidade) {

        // Decidindo qual fábrica vamos usar com base na personalidade
        FabricaPersonagem fabrica = personalidade.equals("Heroico") ? fabricaHeroico : fabricaMalvado;

        // Selcionando a fábrica apropriada para criar o personagem com base nas escolhas do jogador
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

        return "redirect:/personagem";
    }


    @GetMapping("/inimigos")
    public String batalha(Model model) {
        List<Boss> bosses = bossService.listarTodos();
        model.addAttribute("bosses", bosses);
        return "inimigos";
    }

    @GetMapping("/personagem")
    public String listarPersonagens(Model model) {
        Optional<Personagem> personagemOpt = personagemRepository.encontrarUltimoCadastrado();

        if (personagemOpt.isPresent()) {
            Personagem personagem = personagemOpt.get();
            model.addAttribute("personagem", personagem);
        } else {
            model.addAttribute("personagem", "Nenhum personagem cadastrado.");
        }

        return "personagem";
    }

    @GetMapping("/rodada")
    public String mostrarRodada(Model model) {
        rodadas.carregarDadosComuns(model);
        rodadas.setRodadaAtual(1);

        model.addAttribute("rodadaAtual", rodadas.getRodadaAtual());
        rodadas.setRodadaAtual(rodadas.getRodadaAtual() + 1);
        return "rodadas";
    }

    @PostMapping("/rodada")
    public String processarAcaoJogador(@RequestParam("acaoJogador") String acaoJogador, Model model) {
        if (rodadas == null || rodadas.rodadaConcluida()) {
            rodadas = new Rodadas(personagemRepository, bossService);
        }

        if (acaoJogador.equals("desistir")){
            return rodadas.realizarRodada(acaoJogador);
        }

        model.addAttribute("rodadaAtual", rodadas.getRodadaAtual());
        if (rodadas.getRodadaAtual() > 1){
            String mensagemRodada = rodadas.realizarRodada(acaoJogador);
            model.addAttribute("mensagemRodada", mensagemRodada);
        }

        if (rodadas.rodadaConcluida()) {
            String mensagemFimDeJogo = rodadas.mensagemFimDaBatalha();
            String statusFimDeJogo = rodadas.getStatusFimDaRodada();
            model.addAttribute("mensagemFimDeJogo", mensagemFimDeJogo);
            model.addAttribute("statusFimDeJogo", statusFimDeJogo);
            rodadas.resetarPontos();
            rodadas.carregarDadosComuns(model);
            rodadas.definirBoss();

        } else {
            rodadas.carregarDadosComuns(model);
        }

        return "rodadas";

    }
}


