package br.com.zup.controller;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.entity.ApplicationUser;
import br.com.zup.repository.ApplicationUserRepository;
import br.com.zup.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	private UserService userService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@PostMapping("/sign-up")
	public void signUp(@RequestBody ApplicationUser user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userService.postUser(user);
	}

	@RequestMapping("/list")
	public List<ApplicationUser> listPrices() {

		List<ApplicationUser> usersDetails = userService.getUsers();
		return usersDetails;
	}

	public UserController(UserService userService,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userService = userService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
}
