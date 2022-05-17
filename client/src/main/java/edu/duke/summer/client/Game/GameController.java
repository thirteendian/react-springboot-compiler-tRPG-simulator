package edu.duke.summer.client.Game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RestController
public class GameController {

    @RequestMapping("/gameCenter")
    public String greeting(){
        return "game.html";
    }

//    @RequestMapping(value = "/creatGame", method = RequestMethod.GET)
//    public String createLoginForm(HttpServletResponse response){
//        response.setHeader("Content-Type","text/html");
//        return "index.html";
//    }   没办法做连续页面

    @Autowired
    private GameRepository gameRepo;

    @GetMapping("creatGame")
    public String showGameCreateForm(Model model){
        model.addAttribute("newGame", new Game());
        return "creatGame";
    }

    @PostMapping("/process_create")
    public String processCreateGame(Game game){
        gameRepo.save(game);
        return "create_successfully.html";
    }

    @GetMapping("chooseGame")
    public String showGameChooseForm(Model model){
        return "chooseGame";
    }



}