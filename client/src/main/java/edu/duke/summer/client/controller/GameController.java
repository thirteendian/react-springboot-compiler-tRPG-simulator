package edu.duke.summer.client.controller;

import edu.duke.summer.client.database.repository.GameRepository;
import edu.duke.summer.client.dto.GameDto;
import edu.duke.summer.client.dto.ObjectNameDto;
import edu.duke.summer.client.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.Principal;
import java.util.List;

@Controller
public class GameController {

    @Autowired
    GameService gameService;

    @GetMapping("/gameCenter")
    public String greeting(Principal principal, Model model) {

        //Get All Object List to rander
        List<String> objects = gameService.getObjectsList("1");
        model.addAttribute("objects", objects);
        model.addAttribute("curruser", principal.getName());
        model.addAttribute("objectNameDto", new ObjectNameDto());
        return "game";
    }

    @Autowired
    private GameRepository gameRepo;

    @GetMapping("/createGame")
    public String GameCreateForm(Model model) {
        model.addAttribute("gameDto", new GameDto());
        return "createGame";
    }

    @PostMapping("/createGame")
    public String processCreateGame(@ModelAttribute @Valid GameDto gameDto, Model model) {
        model.addAttribute("gameDto", gameDto);
        return "gameCreateSuccess";
    }

    @GetMapping("chooseGame")
    public String showGameChooseForm(Model model) {
        return "chooseGame";
    }


    //private final String UPLOAD_DIR = "./uploads/";

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes attributes) {

        // check if file is empty
        if (file.isEmpty()) {
            attributes.addFlashAttribute("message", "Please select a file to upload.");
            return "redirect:/";
        }

        // normalize the file path
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        String uploadString = "";
        // convert File to be String
        try {

            InputStream inputStream = file.getInputStream();
            InputStreamReader isReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(isReader);
            StringBuffer sb = new StringBuffer();
            String str;
            while ((str = reader.readLine()) != null) {
                sb.append(str);
            }
            System.out.println(sb.toString());
            uploadString = sb.toString();
            //Path path = Paths.get(UPLOAD_DIR + fileName);
            //Save File to the local system
            //Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // return success response
        attributes.addFlashAttribute("message", "You successfully uploaded " + fileName + '!');
        gameService.createObjects("1", uploadString);
        System.out.println("Successfully Create Objects, the Objects List:");
        System.out.println(gameService.getObjectsList("1"));
        return "redirect:/createobject";
    }

    //TODO: This get method should be merged into GamePage
    @GetMapping("/createobject")
    public String createObject(Model model) {
        List<String> objects = gameService.getObjectsList("1");
        model.addAttribute("objects", objects);
        return "object";//TODO:This should be redirected to Game Page
    }

    @PostMapping("/createobject")
    public String createObject(@Valid String objectName) {
        System.out.println("This is the selected objectName: " + objectName);
        return "redirect:/createobject";//TODO:This should be redirected to Game Page
    }
}