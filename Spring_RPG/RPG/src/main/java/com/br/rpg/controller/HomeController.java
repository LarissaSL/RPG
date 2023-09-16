package com.br.rpg.controller;

import com.br.rpg.model.Boss;
import com.br.rpg.service.BossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final BossService bossService;

    @Autowired
    public HomeController(BossService bossService) {
        this.bossService = bossService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro";
    }

    @GetMapping("/batalha")
    public String batalha(Model model) {
        List<Boss> bosses = bossService.listarTodos();
        model.addAttribute("bosses", bosses);
        return "batalha";
    }

    @GetMapping("/rodada")
    public String rodada() {
        return "rodadas";
    }
}
