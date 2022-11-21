package com.binarxbca.chapter5.controller;

import com.binarxbca.chapter5.exception.ResponseEntityErrorException;
import com.binarxbca.chapter5.model.Film;
import com.binarxbca.chapter5.payload.response.ApiResponse;
import com.binarxbca.chapter5.payload.response.FilmResponse;
import com.binarxbca.chapter5.payload.response.PagedResponse;
import com.binarxbca.chapter5.payload.request.FilmRequest;
import com.binarxbca.chapter5.service.FilmService;
import com.binarxbca.chapter5.utils.AppConstants;
import com.binarxbca.chapter5.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/chapter5/films")
public class FilmController {
	@Autowired
	private FilmService filmService;

	@ExceptionHandler(ResponseEntityErrorException.class)
	public ResponseEntity<ApiResponse> handleExceptions(ResponseEntityErrorException exception) {
		return exception.getApiResponse();
	}

	@GetMapping
	public PagedResponse<FilmResponse> getAllFilms(
			@RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
			@RequestParam(name = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {
		AppUtils.validatePageNumberAndSize(page, size);

		return filmService.getAllFilms(page, size);
	}

	@PostMapping
	public ResponseEntity<Film> addFilm(@Valid @RequestBody FilmRequest filmRequest) {
		return filmService.addFilm(filmRequest);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Film> getFilm(@PathVariable(name = "id") Long id) {
		return filmService.getFilm(id);
	}



	@PutMapping("/{id}")
	public ResponseEntity<FilmResponse> updateFilm(@PathVariable(name = "id") Long id, @Valid @RequestBody FilmRequest filmRequest) {
		return filmService.updateFilm(id, filmRequest);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteFilm(@PathVariable(name = "id") Long id) {
		return filmService.deleteFilm(id);
	}
}
