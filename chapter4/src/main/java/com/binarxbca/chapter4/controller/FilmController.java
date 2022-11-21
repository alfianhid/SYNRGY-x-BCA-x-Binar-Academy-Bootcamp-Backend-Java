package com.binarxbca.chapter4.controller;

import com.binarxbca.chapter4.model.Films;
import com.binarxbca.chapter4.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {
    @Autowired
    FilmService filmService;

    @PostMapping("/add")
    public Films addFilm(@RequestBody Films film){
        return filmService.addFilm(film);
    }

    @GetMapping("/film_code/{film_code}")
    public Films getFilmByFilmCode(@PathVariable String film_code){
        return filmService.getFilmByFilmCode(film_code);
    }

    @GetMapping
    public List<Films> getAllFilms(){
        return filmService.getAllFilms();
    }

    @PutMapping("/update")
    public Films updateFilm(@RequestBody Films film){
        return filmService.updateFilm(film);
    }

    @DeleteMapping("/delete")
    public void deleteFilm(@RequestParam String film_code){
        filmService.deleteFilm(film_code);
    }
}