package com.binarxbca.chapter5.service.impl;

import com.binarxbca.chapter5.constant.ResponseMessage;
import com.binarxbca.chapter5.exception.DataAlreadyExistsException;
import com.binarxbca.chapter5.exception.DataNotFoundException;
import com.binarxbca.chapter5.model.film.Film;
import com.binarxbca.chapter5.repository.FilmRepository;
import com.binarxbca.chapter5.service.FilmService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    FilmRepository filmRepository;

    @SneakyThrows
    @Override
    public Film addFilm(Film film) {
        // validasi nama film
//        verifyFilmName(film);

        // untuk mengaktifkan film
        film.setStatus(true);

        // menyimpan film
        return filmRepository.save(film);
    }

    @Override
    public Film getFilmById(String id) {
        // validasi id
        verifyFilmId(id);

        // cari film by id
        return filmRepository.findById(id).get();
    }

    @Override
    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    @SneakyThrows
    @Override
    public Film updateFilm(Film film) {
        // validasi id
        verifyFilmId(film.getId());

        // validasi nama film
        verifyFilmName(film);

        // menyimpan film
        return filmRepository.save(film);
    }

    @Override
    public void deleteFilm(String id) {
        // validasi id
        verifyFilmId(id);

        // hapus film
        filmRepository.deleteById(id);
    }

    private void verifyFilmId(String id){
        if(!filmRepository.findById(id).isPresent()){
            String message = String.format(ResponseMessage.NOT_FOUND_MESSAGE, "film", id);
            throw new DataNotFoundException(message);
        }
    }

    private void verifyFilmName(Film film){
        List<Film> film_name = filmRepository.findFilmByName(film.getName());
        if(film_name.size() > 0) {
            String message = String.format(ResponseMessage.FILM_NAME_ALREADY_EXISTS, "film", film.getName());
            throw new DataAlreadyExistsException(message);
        }
    }
}
