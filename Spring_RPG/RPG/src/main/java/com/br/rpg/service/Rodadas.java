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

    public String realizarRodada(String acaoPersonagem) {
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
                return "Resultado da Rodada: Você atacou e o Boss também!";
            } else {
                this.pontoBoss++;
                return "Resultado da Rodada: Você atacou, mas o Boss defendeu seu ataque.";
            }
        } else {
            if ("atacar".equals(acaoBossEscolhida)) {
                this.pontoPersonagem++;
                return "Resultado da Rodada: O Boss te atacou mas você defendeu." ;
            } else {
                return "Resultado da Rodada: Nenhum dos dois atacou.";
            }
        }

    }

    //Resetar os pontos do Boss e Personagem caso a rodadaAtual seja > 4
    public boolean rodadaConcluida() {
        return this.rodadaAtual > 4;
    }


    public String mensagemFimDaBatalha() {
        String mensagem;

        if (pontoPersonagem > pontoBoss) {
            if (getIndiceDoBoss() + 1 > 2){
                mensagem = "Parabéns você concluido sua jornada e provou seu valor! Bora repetir?!";
                this.atualizarBoss = false;
                setIndiceDoBoss(0);
            } else {
                mensagem = "Parabéns Você Venceu! Vamos para a próxima etapa";
                this.atualizarBoss = true;
            }
        } else if (pontoPersonagem == pontoBoss) {
            mensagem = "Putz, empatou! Bora jogar de novo?" ;
            this.atualizarBoss = false;
        } else {
            mensagem = "Ah que pena, não foi dessa vez... Vamos tentar de novo?";
            this.atualizarBoss = false;
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
