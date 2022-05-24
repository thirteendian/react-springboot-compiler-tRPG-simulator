package edu.duke.summer.client.controller;

import edu.duke.summer.client.database.model.Game;
import edu.duke.summer.client.database.repository.GameRepository;
import edu.duke.summer.client.dto.GameDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
//@RestController
public class GameController {

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
    public String processCreateGame(@ModelAttribute @Valid GameDto gameDto, Model model){
        model.addAttribute("gameDto", gameDto);
        return "gameCreateSuccess";
    }

    @GetMapping("chooseGame")
    public String showGameChooseForm(Model model){
        return "chooseGame";
    }
}