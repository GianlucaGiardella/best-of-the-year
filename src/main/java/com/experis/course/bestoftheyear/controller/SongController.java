package com.experis.course.bestoftheyear.controller;

import com.experis.course.bestoftheyear.model.Movie;
import com.experis.course.bestoftheyear.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongController {

    private List<Song> getSongs() {
        return Arrays.asList(
                new Song(1, "Parole di ghiaccio", "Emis Killa", "Fuori quando è brutto tempo"),
                new Song(2, "Not afraid", "Eminem", "I'm not afraid"),
                new Song(3, "Despacito", "Luis Fonci", "Despacitooo")
        );
    }

    @GetMapping
    public String songs(Model model) {

        List<Song> songs = getSongs();
        model.addAttribute("songList", songs);

        return "songs";
    }

    @GetMapping("/{id}")
    public String songDetails(@PathVariable("id") int songId, Model model) {

        for (Song song : getSongs()) {
            if (song.getId() == songId) {
                model.addAttribute("song", song);
            }
        }

        return "song-details";
    }

}
