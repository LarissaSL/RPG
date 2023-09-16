package com.br.rpg.service;

import com.br.rpg.repository.BossRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.br.rpg.model.Boss;

import java.util.List;
import java.util.Optional;

@Service
public class BossService {
    private final BossRepository bossRepository;

    @Autowired
    public BossService(BossRepository bossRepository) {
        this.bossRepository = bossRepository;
    }

    public List<Boss> listarTodos() {

        return bossRepository.listarTodos();
    }

    public Optional<Boss> listarPorId(int id) {
        return bossRepository.listarPorId(id);
    }

    public Boss salvar(Boss boss) {

        return bossRepository.salvar(boss);
    }

    public void deletarPorId(int id) {

        bossRepository.deletarPorId(id);
    }
}
