package com.binarxbca.chapter5.service;

import com.binarxbca.chapter5.model.Film;
import com.binarxbca.chapter5.payload.request.FilmRequest;
import com.binarxbca.chapter5.payload.response.FilmResponse;
import com.binarxbca.chapter5.payload.response.ApiResponse;
import com.binarxbca.chapter5.payload.response.PagedResponse;
import org.springframework.http.ResponseEntity;

public interface FilmService {
	PagedResponse<FilmResponse> getAllFilms(int page, int size);

	ResponseEntity<Film> addFilm(FilmRequest filmRequest);

	ResponseEntity<Film> getFilm(Long id);

	Film getFilmById(Long id);
	ResponseEntity<FilmResponse> updateFilm(Long id, FilmRequest filmRequest);

	ResponseEntity<ApiResponse> deleteFilm(Long id);

	PagedResponse<Film> getByUserId(Long id, int page, int size);
}
