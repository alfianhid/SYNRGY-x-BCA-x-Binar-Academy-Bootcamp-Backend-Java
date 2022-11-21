package com.binarxbca.chapter5.controller;

import com.binarxbca.chapter5.model.Film;
import com.binarxbca.chapter5.model.User;
import com.binarxbca.chapter5.payload.response.ApiResponse;
import com.binarxbca.chapter5.payload.response.PagedResponse;
import com.binarxbca.chapter5.payload.response.UserIdentityAvailability;
import com.binarxbca.chapter5.payload.response.UserProfile;
import com.binarxbca.chapter5.service.FilmService;
import com.binarxbca.chapter5.service.UserService;
import com.binarxbca.chapter5.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/chapter5/users")
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private FilmService filmService;

	@GetMapping("/checkUsernameAvailability")
	public ResponseEntity<UserIdentityAvailability> checkUsernameAvailability(@RequestParam(value = "username") String username) {
		UserIdentityAvailability userIdentityAvailability = userService.checkUsernameAvailability(username);

		return new ResponseEntity<>(userIdentityAvailability, HttpStatus.OK);
	}

	@GetMapping("/checkEmailAvailability")
	public ResponseEntity<UserIdentityAvailability> checkEmailAvailability(@RequestParam(value = "email") String email) {
		UserIdentityAvailability userIdentityAvailability = userService.checkEmailAvailability(email);
		return new ResponseEntity<>(userIdentityAvailability, HttpStatus.OK);
	}

	@PostMapping("/signup")
	public ResponseEntity<User> signUp(@Valid @RequestBody User user) {
		User newUser = userService.addUser(user);

		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}

	@GetMapping("/{username}/profile")
	public ResponseEntity<UserProfile> getUserProfile(@PathVariable(value = "username") String username) {
		UserProfile userProfile = userService.getUserProfile(username);

		return new ResponseEntity<>(userProfile, HttpStatus.OK);
	}

	@GetMapping("/list")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> listOfUser = userService.getAllUser();

		return new ResponseEntity<>(listOfUser, HttpStatus.OK);
	}

	@PutMapping("/{username}")
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user,
			@PathVariable(value = "username") String username) {
		User updatedUser = userService.updateUser(user, username);

		return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
	}

	@DeleteMapping("/{username}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable(value = "username") String username) {
		ApiResponse apiResponse = userService.deleteUser(username);

		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	@GetMapping("/{username}/films")
	public ResponseEntity<PagedResponse<Film>> getFilmList(@PathVariable(value = "id") Long id,
																 @RequestParam(value = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
																 @RequestParam(value = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {
		PagedResponse<Film> response = filmService.getByUserId(id, page, size);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
