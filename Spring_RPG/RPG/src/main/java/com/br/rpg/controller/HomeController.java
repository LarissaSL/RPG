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
    public String mostrarRodada(Model model) {
        rodadas.carregarDadosComuns(model);
        model.addAttribute("rodadaAtual", rodadas.getRodadaAtual());
        return "rodadas";
    }

    @PostMapping("/rodada")
    public String processarAcaoJogador(@RequestParam("acaoJogador") String acaoJogador, Model model) {
        if (rodadas == null || rodadas.rodadaConcluida()) {
            rodadas = new Rodadas(personagemRepository, bossService);
        }

        model.addAttribute("rodadaAtual", rodadas.getRodadaAtual());
        String mensagemRodada = rodadas.realizarRodada(acaoJogador);
        model.addAttribute("mensagemRodada", mensagemRodada);

        if (rodadas.rodadaConcluida()) {
            String mensagemFimDeJogo = rodadas.mensagemFimDaBatalha();
            model.addAttribute("mensagemFimDeJogo", mensagemFimDeJogo);
            rodadas.setRodadaAtual(1);
        }

        rodadas.carregarDadosComuns(model);

        return "rodadas";

        /*
        * Quase lá, primeiro ta indo Rodada1 e os botoes de Atk e Def
        *  Cliquei volta pro Rodada 1 e os Botoes atk e Def
        * Rodada2 mensagem do que rolou e os botoes de Atk e Def
        * Rodada 3 mensagem do que rolou e os botoes de atk e def + FIm de Jogo
        * Só funciona direitinho o Fluxo de Rodada 1, Rodada 2 e Rodada 3 se eu jpá tiver feito uma luta
        * Coisas a Resolver
        * 1 - Arrumar o Fluxo das Rodadas(1, 2 e depois a 3, sendo que na 3 tira os botoes de atk e def
        * 2 - Ver a sobre atualização do Boss caso ganhe e caso perca/empate um botão de tentar de novo*/
    }
}


