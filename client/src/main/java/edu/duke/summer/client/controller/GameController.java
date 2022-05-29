package edu.duke.summer.client.controller;

import edu.duke.summer.client.database.model.Game;
//import edu.duke.summer.client.database.repository.GameRepository;
import edu.duke.summer.client.database.repository.GameRepository;
import edu.duke.summer.client.dto.GameDto;
import edu.duke.summer.client.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
//@RestController
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping("/gameCenter")
    public String greeting(){
        return "game";
    }

    @Autowired
    private GameRepository gameRepo;

    @GetMapping("/createGame")
    public String GameCreateForm(Model model){
        model.addAttribute("gameDto", new GameDto());
        return "createGame";
    }

    @PostMapping("/createGame")
    public String processCreateGame(@ModelAttribute @Valid GameDto gameDto, Model model) {
        try {
            Game game = gameService.createNewGame(gameDto);
        } catch (Exception e) {
            e.printStackTrace();
            return "/createGame";
        }
        model.addAttribute("gameDto", gameDto);
        return "gameCreateSuccess";
    }

    @GetMapping("gameFilter")
    public String gameFilter(Model model){
        List<Game> games = gameService.findAllGames();
        model.addAttribute("gamesFromDB", games);
        return "gameFilter";
    }
}