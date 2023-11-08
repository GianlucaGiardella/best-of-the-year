package com.experis.course.bestoftheyear.controller;

import com.experis.course.bestoftheyear.model.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private List<Movie> getMovies() {
        return Arrays.asList(
                new Movie(1, "Il Cavaliere Oscuro", "Christofer Nolan", "BATMAN"),
                new Movie(2, "Iron-Man", "Stan Lee", "Io sono Iron Man"),
                new Movie(3, "Fast and Furious", "Gary Scott Thompson", "Vivo un quarto di miglio alla volta")
        );
    }

    @GetMapping
    public String movies(Model model) {

        List<Movie> movies = getMovies();
        model.addAttribute("movieList", movies);

        return "movies";
    }

    @GetMapping("/{id}")
    public String movieDetails(@PathVariable("id") int movieId, Model model) {

        for (Movie movie : getMovies()) {
            if (movie.getId() == movieId) {
                model.addAttribute("movie", movie);
            }
        }

        return "movie-details";
    }

}
