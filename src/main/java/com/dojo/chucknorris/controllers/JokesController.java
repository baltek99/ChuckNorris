package com.dojo.chucknorris.controllers;

import com.dojo.chucknorris.models.Joke;
import com.dojo.chucknorris.service.JokeService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Collection;

@Controller
public class JokesController {

    private final JokeService jokeService;

    public JokesController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @GetMapping("/getJoke")
    public String getJoke(Model model) {
        try {
            String joke = jokeService.getJoke().getValue();
            model.addAttribute("joke", joke);
            System.out.println(joke);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "index";
    }

    @GetMapping("/getAndSaveJoke")
    public String getAndSaveJoke(Model model) {
        try {
            Joke joke = jokeService.getJoke();
            jokeService.saveJoke(joke);
            model.addAttribute("joke", joke.getValue());
            System.out.println(joke.getValue());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "index";
    }

    @GetMapping("/getJokes")
    public String getAllJokes(Model model) {
        model.addAttribute("jokes", jokeService.getAllJokes());
        return "jokes";
    }

    @RequestMapping(value = "/userRole", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserRole(Authentication authentication) {
        return authentication.getAuthorities().toString();
    }
}
