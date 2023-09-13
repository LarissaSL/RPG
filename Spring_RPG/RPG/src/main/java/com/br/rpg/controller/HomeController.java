package com.br.rpg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {

    @GetMapping("/")
    public String index (){
        return "index";
    }

    @GetMapping("/cadastro")
    public String cadastro (){
        return "cadastro";
    }

    @GetMapping("/batalha")
    public String batalha (){
        return "batalha";
    }

    @GetMapping("/rodada")
    public String rodada (){
        return "rodadas";
    }
}
