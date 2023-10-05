package com.br.rpg.service;
import org.springframework.ui.Model;
import com.br.rpg.model.Boss;
import com.br.rpg.model.Personagem;
import com.br.rpg.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class Rodadas {
    private int pontoPersonagem;
    private int pontoBoss;
    private int rodadaAtual;
    private String statusFimDaRodada;
    private int indiceDoBoss;
    private boolean atualizarBoss;
    private final PersonagemRepository personagemRepository;
    private final BossService bossService;

    @Autowired
    public Rodadas(PersonagemRepository personagemRepository, BossService bossService) {
        this.personagemRepository = personagemRepository;
        this.bossService = bossService;
        this.rodadaAtual = 1;
    }

    public void carregarDadosComuns(Model model) {
        List<Personagem> personagens = personagemRepository.listarTodos();
        if (!personagens.isEmpty()) {
            Personagem ultimoPersonagem = personagens.get(personagens.size() - 1);
            model.addAttribute("ultimoPersonagem", ultimoPersonagem);
        }

        List<Boss> bosses = bossService.listarTodos();
        model.addAttribute("bosses", bosses);

        Boss bossAtual = bosses.get(getIndiceDoBoss());
        model.addAttribute("bossAtual", bossAtual);
    }

    public int getIndiceDoBoss() {
        return indiceDoBoss;
    }

    public void setIndiceDoBoss(int indiceDoBoss) {
        this.indiceDoBoss = indiceDoBoss;
    }

    public void setPontoPersonagem(int pontoPersonagem) {
        this.pontoPersonagem = pontoPersonagem;
    }

    public void setPontoBoss(int pontoBoss) {
        this.pontoBoss = pontoBoss;
    }

    public int getPontoPersonagem() {
        return pontoPersonagem;
    }

    public int getPontoBoss() {
        return pontoBoss;
    }

    public int getRodadaAtual() {
        return rodadaAtual;
    }

    public void setRodadaAtual(int rodadaAtual) {
        this.rodadaAtual = rodadaAtual;
    }

    public String getStatusFimDaRodada() {
        return statusFimDaRodada;
    }

    public void setStatusFimDaRodada(String statusFimDaRodada) {
        this.statusFimDaRodada = statusFimDaRodada;
    }

    public String realizarRodada(String acaoPersonagem) {
        if ("desistir".equals(acaoPersonagem)){
            return "index";
        }

        Random rand = new Random();
        int acaoBoss = rand.nextInt(2);
        String acaoBossEscolhida;

        if (acaoBoss == 1) {
            acaoBossEscolhida = "atacar";
        } else {
            acaoBossEscolhida = "defender";
        }

        this.rodadaAtual++;


        if ("atacar".equals(acaoPersonagem)) {
            if ("atacar".equals(acaoBossEscolhida)) {
                this.pontoPersonagem++;
                this.pontoBoss++;
                return "Resultado da Rodada: Você atacou e o Boss revidou!";
            } else {
                this.pontoBoss++;
                return "Resultado da Rodada: Você deu a investida e o boss a defendida.";
            }
        } else {
            if ("atacar".equals(acaoBossEscolhida)) {
                this.pontoPersonagem++;
                return "Resultado da Rodada: O Boss te atacou mas você defendeu." ;
            } else {
                return "Resultado da Rodada: Vocês não se bateram, os dois se defenderam!";
            }
        }

    }

    public boolean rodadaConcluida() {
        return this.rodadaAtual > 4;
    }

    // Status do final da Batalha e configurações para próxima
    public String mensagemFimDaBatalha() {
        String mensagem;

        if (pontoPersonagem > pontoBoss) {
            if (getIndiceDoBoss() + 1 > 2){
                mensagem = "Parabéns você concluiu! Mostrou para todos que conseguiu. Agora que você é o mais forte " +
                        "porque não tentar mais uma vez a sorte?";
                this.atualizarBoss = false;
                setStatusFimDaRodada("(Vitória)");
                setIndiceDoBoss(0);
            } else {
                mensagem = "Parabéns você venceu e a próxima etapa mereceu! Já que está a todo vapor porque não mostrar " +
                        "mais uma vez o seu valor?";
                this.atualizarBoss = true;
                setStatusFimDaRodada("(Vitória)");
            }
        } else if (pontoPersonagem == pontoBoss) {
            mensagem = "Eita, o que rolou? Seu jogo empatou!" ;
            this.atualizarBoss = false;
            setStatusFimDaRodada("(Empate)");
        } else {
            mensagem = "Ah que pena, não foi dessa vez... porque não tentar mais uma vez?";
            this.atualizarBoss = false;
            setStatusFimDaRodada("(Derrota)");
        }
        return mensagem;
    }

    public void definirBoss() {
        if (atualizarBoss && indiceDoBoss < 2) {
            this.indiceDoBoss++;
        }
    }

    public void resetarPontos(){
        setPontoPersonagem(0);
        setPontoBoss(0);
    }

}
