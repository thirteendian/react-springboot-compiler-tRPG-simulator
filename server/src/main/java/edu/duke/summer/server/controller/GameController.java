package edu.duke.summer.server.controller;

import edu.duke.summer.server.database.model.FunctionInfo;
import edu.duke.summer.server.database.repository.GameRepository;
import edu.duke.summer.server.dto.CreateGameDto;
import edu.duke.summer.server.dto.Object.ObjectDto;
import edu.duke.summer.server.dto.Request.CreateGameRequestDto;
import edu.duke.summer.server.dto.Request.GameStartRequestDto;
import edu.duke.summer.server.dto.Response.*;
import edu.duke.summer.server.service.GameService;
import edu.duke.summer.server.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/user")
@RestController
public class GameController {

    @Autowired
    GameService gameService;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @PostMapping("/creategame")
//    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> postCreateGame(@Valid @RequestBody CreateGameRequestDto createGameRequestDto) {
        System.out.println(createGameRequestDto);
        CreateGameResponseDto createGameResponseDto = gameService.createNewGame(createGameRequestDto);
        return ResponseEntity.ok(createGameResponseDto);
    }

    @PostMapping("/startgame")
    public ResponseEntity<?> postStartGame(@Valid @RequestBody GameStartRequestDto gameStartRequestDto){
        GameStartResponseDto gameStartResponseDto = gameService.startGame(gameStartRequestDto);
        return ResponseEntity.ok(gameStartResponseDto);
    }





//    @GetMapping("/user/{uuid}/creategame")
//    public String getCreateGame(@PathVariable String uuid, Model model) {
//        model.addAttribute("uuid", uuid);
//        model.addAttribute("createGameDto", new CreateGameDto());
//        return "create_game";
//    }
//
//
//    @PostMapping("/user/{uuid}/creategame")
//    public String postCreateGame(@RequestParam("file") MultipartFile file, RedirectAttributes attributes,
//                                 @PathVariable String uuid, @ModelAttribute @Valid CreateGameRequestDto createGameRequestDto) {
//        gameService.createNewGame(createGameRequestDto);
//        // check if file is empty
//        if (file.isEmpty()) {
//            attributes.addFlashAttribute("message", "Please select a file to upload.");
//            return "redirect:/";
//        }
//        // normalize the file path
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//        String uploadString = "";
//        // convert File to be String
//        try {
//
//            InputStream inputStream = file.getInputStream();
//            InputStreamReader isReader = new InputStreamReader(inputStream);
//            BufferedReader reader = new BufferedReader(isReader);
//            StringBuffer sb = new StringBuffer();
//            String str;
//            while ((str = reader.readLine()) != null) {
//                sb.append(str);
//            }
//            System.out.println(sb.toString());
//            uploadString = sb.toString();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
////        gameService.createObjects(createGameDto.getId(), uploadString);
////        return "redirect:/user/" + uuid + "/" + createGameDto.getId() + "/gamecenter";
//        return null;
//    }
//
//    @GetMapping("/user/{uuid}/{gameid}/gamecenter")
//    public String greeting(@PathVariable String uuid, @PathVariable String gameid) {
//        System.out.println("Current Game :" + gameid);
//        return"game_center";
//    }
//
//    @Autowired
//    private GameRepository gameRepo;
//
////    @GetMapping("/createGame")
////    public String GameCreateForm(Model model) {
////        model.addAttribute("gameDto", new CreateGameDto());
////        return "00creategame";
//////        return "create_game";
////    }
//
////    @PostMapping("/createGame")
////    public String processCreateGame(@ModelAttribute @Valid CreateGameDto createGameDto, Model model) {
////        model.addAttribute("gameDto", createGameDto);
////        return "gameCreateSuccess";
////    }
//
//
//    //private final String UPLOAD_DIR = "./uploads/";
//
//    @PostMapping("/upload")
//    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes attributes) {
//
//        // check if file is empty
//        if (file.isEmpty()) {
//            attributes.addFlashAttribute("message", "Please select a file to upload.");
//            return "redirect:/";
//        }
//
//        // normalize the file path
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//
//        String uploadString = "";
//        // convert File to be String
//        try {
//
//            InputStream inputStream = file.getInputStream();
//            InputStreamReader isReader = new InputStreamReader(inputStream);
//            BufferedReader reader = new BufferedReader(isReader);
//            StringBuffer sb = new StringBuffer();
//            String str;
//            while ((str = reader.readLine()) != null) {
//                sb.append(str);
//            }
//            System.out.println(sb.toString());
//            uploadString = sb.toString();
//            //Path path = Paths.get(UPLOAD_DIR + fileName);
//            //Save File to the local system
//            //Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // return success response
//        attributes.addFlashAttribute("message", "You successfully uploaded " + fileName + '!');
//        //gameService.initializeGame("1", uploadString);
//        System.out.println("Successfully Create Objects, the Objects List:");
//        System.out.println(gameService.getObjectTypes("1"));
//        return "redirect:/createobject";
//    }
//
//    //TODO: This get method should be merged into GamePage
//    @GetMapping("/createobject")
//    public String createObject(Model model) {
//        List<String> objects = gameService.getObjectTypes("1");
//        model.addAttribute("objects", objects);
//        return "object";//TODO:This should be redirected to Game Page
//    }
//
//    @PostMapping("/createobject")
//    public String createObject(@Valid String objectName) {
//        System.out.println("This is the selected objectName: " + objectName);
//        return "redirect:/createobject";//TODO:This should be redirected to Game Page
//    }
//
//
//    /*
//    html frame work for game center,object page
//     */
//    @GetMapping("/joinGame")
//    public String showGameList(Model model) {
//        return "join_game";
//    }
//
//    @GetMapping("/loadGame")
//    public String showLoadList(Model model) {
//        return "load_game";
//    }
//
//    @GetMapping("/gameCenter")
//    public String showGameCenter(Model model) {
//        return "game_center";
//    }
//
//    @GetMapping("/createObject")
//    public String showGameChooseForm(Model model) {
//        return "object";
//    }
//
//    @GetMapping("/invitePlayer")
//    public String getInvitePlayer(Model model) {
//        return "invite_player";
//    }


}