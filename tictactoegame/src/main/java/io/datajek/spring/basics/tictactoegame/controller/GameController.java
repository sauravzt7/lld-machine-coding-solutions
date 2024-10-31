package io.datajek.spring.basics.tictactoegame.controller;

import io.datajek.spring.basics.tictactoegame.models.Game;
import io.datajek.spring.basics.tictactoegame.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("game")
public class GameController {
    @Autowired
    private GameService gameService;

    @ModelAttribute("game")
    public Game getGame() {
        return new Game();
    }

    @GetMapping("/")
    public String home(@ModelAttribute("game") Game game, Model model) {
        model.addAttribute("game", game);
        return "game";
    }

    @PostMapping("/move")
    public String home(@ModelAttribute("game") Game game,
                       @RequestParam int row,
                       @RequestParam int col,
                       Model model) {
        gameService.makeMove(game, row, col);
        model.addAttribute("game", game);
        return "game";
    }

    @PostMapping("/reset")
    public String reset(SessionStatus status){
        status.setComplete();
        return "redirect:/";
    }

}
