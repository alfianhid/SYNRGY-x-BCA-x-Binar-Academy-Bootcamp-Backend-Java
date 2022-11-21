package com.binarxbca.chapter4.service;

import com.binarxbca.chapter4.constant.ResponseMessage;
import com.binarxbca.chapter4.exception.DataNotFoundException;
import com.binarxbca.chapter4.model.Films;
import com.binarxbca.chapter4.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    FilmRepository filmRepository;

    @Override
    public Films addFilm(Films film) {
        film.setFilm_status(Boolean.TRUE);
        return filmRepository.save(film);
    }

    @Override
    public Films getFilmByFilmCode(String film_code) {
        verifyFilm(film_code);
        return filmRepository.findById(film_code).get();
    }

    @Override
    public List<Films> getAllFilms() {
        return filmRepository.findAll();
    }

    @Override
    public Films updateFilm(Films film) {
        verifyFilm(film.getFilm_code());
        return filmRepository.save(film);
    }

    @Override
    public void deleteFilm(String film_code) {
        verifyFilm(film_code);
        filmRepository.deleteById(film_code);
    }

    private void verifyFilm(String film_code){
        if(!filmRepository.findById(film_code).isPresent()){
            String message = String.format(ResponseMessage.NOT_FOUND_MESSAGE, "film", film_code);
            throw new DataNotFoundException(message);
        }
    }
}
