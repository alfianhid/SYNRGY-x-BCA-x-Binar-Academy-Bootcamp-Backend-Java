package com.binarxbca.chapter5.service.impl;

import com.binarxbca.chapter5.exception.BadRequestException;
import com.binarxbca.chapter5.exception.ResourceNotFoundException;
import com.binarxbca.chapter5.model.Film;
import com.binarxbca.chapter5.model.User;
import com.binarxbca.chapter5.payload.response.FilmResponse;
import com.binarxbca.chapter5.repository.FilmRepository;
import com.binarxbca.chapter5.payload.response.ApiResponse;
import com.binarxbca.chapter5.payload.response.PagedResponse;
import com.binarxbca.chapter5.payload.request.FilmRequest;
import com.binarxbca.chapter5.repository.UserRepository;
import com.binarxbca.chapter5.service.FilmService;
import com.binarxbca.chapter5.utils.AppUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.binarxbca.chapter5.utils.AppConstants.*;

@Service
public class FilmServiceImpl implements FilmService {
	@Autowired
	private FilmRepository filmRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public PagedResponse<FilmResponse> getAllFilms(int page, int size) {
		AppUtils.validatePageNumberAndSize(page, size);

		Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, CREATED_AT);

		Page<Film> films = filmRepository.findAll(pageable);

		if (films.getNumberOfElements() == 0) {
			return new PagedResponse<>(Collections.emptyList(), films.getNumber(), films.getSize(),
					films.getTotalElements(), films.getTotalPages(), films.isLast());
		}

		List<FilmResponse> filmResponse = Arrays.asList(modelMapper.map(films.getContent(), FilmResponse[].class));

		return new PagedResponse<>(filmResponse, films.getNumber(), films.getSize(),
				films.getTotalElements(), films.getTotalPages(), films.isLast());
	}

	@Override
	public ResponseEntity<Film> addFilm(FilmRequest filmRequest) {
		Film film = new Film();

		modelMapper.map(filmRequest, film);

		Film film1 = filmRepository.save(film);
		return new ResponseEntity<>(film1, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Film> getFilm(Long id) {
		Film film = filmRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(FILM, ID, id));
		return new ResponseEntity<>(film, HttpStatus.OK);
	}

	@Override
	public Film getFilmById(Long id) {
		if (!filmRepository.findById(id).isPresent()) {
			ApiResponse apiResponse = new ApiResponse(Boolean.FALSE, "Film ID is not found");
			throw new BadRequestException(apiResponse);
		}

		return filmRepository.findById(id).get();
	}

	@Override
	public ResponseEntity<FilmResponse> updateFilm(Long id, FilmRequest filmRequest) {
		Film film = filmRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(FILM, ID, id));

		film.setTitle(film.getTitle());
		film.setRating(film.getRating());

		Film updatedFilm = filmRepository.save(film);

		FilmResponse filmResponse = new FilmResponse();

		modelMapper.map(updatedFilm, filmResponse);

		return new ResponseEntity<>(filmResponse, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ApiResponse> deleteFilm(Long id) {
		filmRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(FILM, ID, id));

		filmRepository.deleteById(id);

		return new ResponseEntity<>(new ApiResponse(Boolean.TRUE, "You successfully deleted film"), HttpStatus.OK);
	}

	@Override
	public PagedResponse<Film> getByUserId(Long userId, int page, int size) {
		User user = userRepository.findById(userId).get();

		Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, CREATED_AT);

		Page<Film> films = filmRepository.findByUserId(user.getId(), pageable);

		List<Film> content = films.getNumberOfElements() > 0 ? films.getContent() : Collections.emptyList();

		return new PagedResponse<>(content, films.getNumber(), films.getSize(), films.getTotalElements(), films.getTotalPages(), films.isLast());
	}
}
