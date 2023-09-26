package com.br.rpg.repository;

import com.br.rpg.model.Boss;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class BossRepository {
    private final List<Boss> bossList = new ArrayList<>();
    private int nextId = 1;

    //Construtor que já Instancia os 3 Boss padrão do RPG
    public BossRepository() {
        Boss minotauro = new Boss();
        minotauro.setId(1);
        minotauro.setNome("Minotauro");
        minotauro.setDificuldade("Facil");
        minotauro.setVida(150);
        minotauro.setAtq(20);
        minotauro.setDef(20);
        minotauro.setDescricao("Minotauro uma criatura vilanesca, corpo de homem e um touro é sua cabeça, por " +
                "onde ele passa não há paz, é melhor tomar cuidado com seu apetite voraz, é melhor você escolher " +
                "se quer sobreviver ou morrer.");

        bossList.add(minotauro);

        Boss cerbero = new Boss();
        cerbero.setId(2);
        cerbero.setNome("Cerbero");
        cerbero.setDificuldade("Medio");
        cerbero.setVida(200);
        cerbero.setAtq(40);
        cerbero.setDef(30);
        cerbero.setDescricao("Para derrotar o mal, precisa lidar com um grande cão infernal, guardando uma enorme " +
                "porteira onde não se pode dar bobeira, Cérbero é o nome do cão malvado, cuidado ou será devorado.");

        bossList.add(cerbero);

        Boss elicius = new Boss();
        elicius.setId(3);
        elicius.setNome("Elicius");
        elicius.setDificuldade("Dificil");
        elicius.setVida(300);
        elicius.setAtq(50);
        elicius.setDef(30);
        elicius.setDescricao("Um dragão negro com raio e trovão, assusta a todos com sua imensidão, um monstro " +
                "alado que esbraveja força por sua calda, todos os conhecem como Elicius e se tiver sorte ele " +
                "escutará seus suplícios.");

        bossList.add(elicius);
    }

    public List<Boss> listarTodos() {

        return bossList;
    }

    public Optional<Boss> listarPorId(int id) {
        return bossList.stream().filter(boss -> boss.getId() == id).findFirst();
    }

    public Boss salvar(Boss boss) {
        if (boss.getId() == 0) {
            boss.setId(nextId++);
            bossList.add(boss);
        } else {
            bossList.replaceAll(existingBoss -> {
                if (existingBoss.getId() == boss.getId()) {
                    return boss;
                }
                return existingBoss;
            });
        }
        return boss;
    }

    public void deletarPorId(int id) {
        bossList.removeIf(boss -> boss.getId() == id);
    }
}
