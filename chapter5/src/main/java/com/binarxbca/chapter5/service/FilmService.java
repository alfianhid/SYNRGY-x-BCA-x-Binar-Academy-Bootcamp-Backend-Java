package com.binarxbca.chapter5.service;

import com.binarxbca.chapter5.model.film.Film;

import java.util.List;

public interface FilmService {
    public Film addFilm(Film film);
    public Film getFilmById(String id);
    public List<Film> getAllFilms();
    public Film updateFilm(Film film);
    public void deleteFilm(String id);
}
