package com.experis.course.bestoftheyear.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping("home")
    public String home(Model model) {
        String name = "Gianluca";
        model.addAttribute("title", "Best of the year by " + name);
        return "home";
    }

    private List<String> getBestMovies() {
        List<String> movies = new ArrayList<>();
        movies.add("Il Cavaliere Oscuro");
        movies.add("Iron-Man");
        movies.add("Fast and Furious");
        return movies;
    }

    private List<String> getBestSongs() {
        List<String> songs = new ArrayList<>();
        songs.add("Parole di ghiaccio");
        songs.add("Not afraid");
        songs.add("Despacito");
        return songs;
    }

    @GetMapping("movies")
    public String movies(Model model) {
        model.addAttribute("movies", String.join(", ", getBestMovies()));
        return "movies";
    }

    @GetMapping("songs")
    public String songs(Model model) {
        model.addAttribute("songs", String.join(", ", getBestSongs()));
        return "songs";
    }
}
