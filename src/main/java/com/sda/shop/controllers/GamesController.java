package com.sda.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gameswebgl")
public class GamesController {

    @GetMapping()
    public String gameSite() {
        return "game";
    }
}
