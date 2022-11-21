package com.binarxbca.chapter4.service;

import com.binarxbca.chapter4.model.Films;

import java.time.LocalDate;
import java.util.List;

public interface FilmService {
    public Films addFilm(Films film);
    public Films getFilmByFilmCode(String film_code);
    public List<Films> getAllFilms();
    public Films updateFilm(Films film);
    public void deleteFilm(String film_code);
}
