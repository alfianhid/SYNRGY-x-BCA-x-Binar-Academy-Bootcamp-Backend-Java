package com.binarxbca.chapter5.service;

import com.binarxbca.chapter5.model.User;
import com.binarxbca.chapter5.payload.response.ApiResponse;
import com.binarxbca.chapter5.payload.response.UserIdentityAvailability;
import com.binarxbca.chapter5.payload.response.UserProfile;

import java.util.List;

public interface UserService {
	UserIdentityAvailability checkUsernameAvailability(String username);

	UserIdentityAvailability checkEmailAvailability(String email);

	User addUser(User user);

	List<User> getAllUser();

	UserProfile getUserProfile(String username);

	User getUserById(Long id);

	User updateUser(User user, String username);

	ApiResponse deleteUser(String username);
}