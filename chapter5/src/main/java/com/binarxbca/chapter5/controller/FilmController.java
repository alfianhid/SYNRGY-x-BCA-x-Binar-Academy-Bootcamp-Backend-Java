package com.binarxbca.chapter5.controller;

import com.binarxbca.chapter5.model.film.Film;
import com.binarxbca.chapter5.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/film")
public class FilmController {
    @Autowired
    FilmService filmService;

    @PostMapping("/add")
    public Film addFilm(@Valid @RequestBody Film film){
        return filmService.addFilm(film);
    }

    @GetMapping("/id/{id}")
    public Film getFilmById(@PathVariable String id){
        return filmService.getFilmById(id);
    }

    @GetMapping
    public List<Film> getAllFilms(){
        return filmService.getAllFilms();
    }

    @PutMapping("/update")
    public Film updateFilm(@Valid @RequestBody Film film){
        return filmService.updateFilm(film);
    }

    @DeleteMapping("/delete")
    public void deleteFilm(@RequestParam String id){
        filmService.deleteFilm(id);
    }
}